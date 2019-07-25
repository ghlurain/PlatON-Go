// Copyright 2019 The go-ethereum Authors
// This file is part of the go-ethereum library.
//
// The go-ethereum library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// The go-ethereum library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with the go-ethereum library. If not, see <http://www.gnu.org/licenses/>.

// Package wal implements the similar write-ahead logging for cbft consensus.
package wal

import (
	"errors"
	"os"
	"path/filepath"
	"time"

	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/protocols"

	"github.com/PlatONnetwork/PlatON-Go/log"
	"github.com/PlatONnetwork/PlatON-Go/node"
	"github.com/PlatONnetwork/PlatON-Go/rlp"
	"github.com/syndtr/goleveldb/leveldb/opt"
)

const (
	// Wal working directory
	walDir = "wal"
	// Wal database name
	metaDBName = "wal_meta"
)

var (
	chainStateKey = []byte("chain-state") // Key of chainState to store leveldb
	viewChangeKey = []byte("view-change") // Key of viewChange to store leveldb
)

var (
	errCreateWalDir         = errors.New("failed to create wal directory")
	errUpdateViewChangeMeta = errors.New("failed to update viewChange meta")
	errGetViewChangeMeta    = errors.New("failed to get viewChange meta")
	errGetChainState        = errors.New("failed to get chainState")
)

// recoveryChainStateFn is a callback type for recovery chainState to consensus.
type recoveryChainStateFn func(chainState *protocols.ChainState)

// recoveryConsensusMsgFn is a callback type for recovery message to consensus.
type recoveryConsensusMsgFn func(msg interface{})

type ViewChangeMessage struct {
	Epoch      uint64
	ViewNumber uint64
	FileID     uint32
	Seq        uint64
}

// Wal encapsulates functions required to update and load consensus state.
type Wal interface {
	UpdateChainState(chainState *protocols.ChainState) error
	LoadChainState(fn recoveryChainStateFn) error
	Write(msg interface{}) error
	WriteSync(msg interface{}) error
	UpdateViewChange(info *ViewChangeMessage) error
	Load(fn recoveryConsensusMsgFn) error
	Close()
}

// emptyWal is a empty implementation for wal
type emptyWal struct {
}

func (w *emptyWal) UpdateChainState(chainState *protocols.ChainState) error {
	return nil
}

func (w *emptyWal) LoadChainState(fn recoveryChainStateFn) error {
	return nil
}

func (w *emptyWal) Write(msg interface{}) error {
	return nil
}

func (w *emptyWal) WriteSync(msg interface{}) error {
	return nil
}

func (w *emptyWal) UpdateViewChange(info *ViewChangeMessage) error {
	return nil
}

func (w *emptyWal) Load(fn recoveryConsensusMsgFn) error {
	return nil
}

func (w *emptyWal) Close() {
}

// baseWal is a default implementation for wal
type baseWal struct {
	path    string // Wal working directory
	metaDB  IWALDatabase
	journal *journal
}

// NewWal creates a new wal to update and load consensus state.
func NewWal(ctx *node.ServiceContext, specifiedPath string) (Wal, error) {
	if ctx == nil && len(specifiedPath) == 0 {
		return &emptyWal{}, nil
	}
	var (
		originPath = specifiedPath
		metaDB     IWALDatabase
		walPath    string
		journal    *journal
		err        error
	)
	if originPath == "" {
		originPath = ctx.ResolvePath(walDir)
	}

	// Make sure the wal directory exists,If not exist create it.
	ensureWalDir := func(path string) (string, error) {
		if _, err := os.Stat(path); os.IsNotExist(err) {
			err := os.MkdirAll(path, 0700)
			if err != nil {
				return "", errCreateWalDir
			}
		}
		return path, nil
	}
	// Open or create WAL Database
	createMetaDB := func(path, name string) (IWALDatabase, error) {
		db, err := createWalDB(filepath.Join(path, name))
		if err != nil {
			return nil, err
		}
		return db, nil
	}

	if walPath, err = ensureWalDir(originPath); err != nil {
		log.Error("Failed to create wal directory", "err", err)
		return nil, err
	}
	if journal, err = NewJournal(walPath); err != nil {
		return nil, err
	}
	if metaDB, err = createMetaDB(walPath, metaDBName); err != nil {
		log.Error("Failed to create wal database", "err", err)
		return nil, err
	}

	wal := &baseWal{
		path:    walPath,
		metaDB:  metaDB,
		journal: journal,
	}

	return wal, nil
}

// UpdateChainState tries to update consensus state to leveldb
func (wal *baseWal) UpdateChainState(chainState *protocols.ChainState) error {
	data, err := rlp.EncodeToBytes(chainState)
	if err != nil {
		return err
	}
	// Write the chainState to the WAL database
	err = wal.metaDB.Put(chainStateKey, data, &opt.WriteOptions{Sync: true})
	if err != nil {
		return err
	}
	log.Debug("Success to update chainState")
	return nil
}

// LoadChainState tries to load consensus state from leveldb
func (wal *baseWal) LoadChainState(recovery recoveryChainStateFn) error {
	// open wal database
	data, err := wal.metaDB.Get(chainStateKey)
	if err != nil {
		log.Warn("Failed to get chainState from db,may be the first time to run platon")
		return nil
	}
	var cs protocols.ChainState
	err = rlp.DecodeBytes(data, &cs)
	if err != nil {
		log.Error("Failed to decode chainState")
		return errGetChainState
	}
	recovery(&cs)
	return nil
}

// Write adds the specified consensus msg to the local disk journal.
// the mode is asynchronous write,the msg will cache in bufio.Writer
func (wal *baseWal) Write(msg interface{}) error {
	return wal.journal.Insert(&Message{
		Timestamp: uint64(time.Now().UnixNano()),
		Data:      msg,
	}, false)
}

// WriteSync adds the specified consensus msg to the local disk journal.
// the mode is synchronous write,the msg will flush to disk immediately
func (wal *baseWal) WriteSync(msg interface{}) error {
	return wal.journal.Insert(&Message{
		Timestamp: uint64(time.Now().UnixNano()),
		Data:      msg,
	}, true)
}

// UpdateViewChange tries to update consensus confirm viewChange to leveldb
func (wal *baseWal) UpdateViewChange(info *ViewChangeMessage) error {
	return wal.updateViewChangeMeta(info)
}

// Load tries to load consensus msg from the local disk journal.
// recovery is the callback function
func (wal *baseWal) Load(recovery recoveryConsensusMsgFn) error {
	// open wal database
	data, err := wal.metaDB.Get(viewChangeKey)
	if err != nil {
		log.Warn("Failed to get viewChange meta from db,may be the first time to run platon")
		return nil
	}
	var vc ViewChangeMessage
	err = rlp.DecodeBytes(data, &vc)
	if err != nil {
		log.Error("Failed to decode viewChange meta")
		return errGetViewChangeMeta
	}

	return wal.journal.LoadJournal(vc.FileID, vc.Seq, recovery)
}

// updateViewChangeMeta update the ViewChange Meta Data to the database.
func (wal *baseWal) updateViewChangeMeta(vc *ViewChangeMessage) error {
	fileID, seq, err := wal.journal.CurrentJournal()
	if err != nil {
		log.Error("Failed to update viewChange meta", "epoch", vc.Epoch, "viewNumber", vc.ViewNumber, "err", err)
		return errUpdateViewChangeMeta
	}

	vc.FileID = fileID
	vc.Seq = seq
	data, err := rlp.EncodeToBytes(vc)
	if err != nil {
		return err
	}
	// Write the ViewChangeMeta to the WAL database
	err = wal.metaDB.Put(viewChangeKey, data, &opt.WriteOptions{Sync: true})
	if err != nil {
		return err
	}
	log.Debug("Success to update viewChange meta", "epoch", vc.Epoch, "viewNumber", vc.ViewNumber, "fileID", fileID, "seq", seq)
	// Delete previous journal logs
	go wal.journal.ExpireJournalFile(fileID)
	return nil
}

func (wal *baseWal) Close() {
	wal.metaDB.Close()
	wal.journal.Close()
}
