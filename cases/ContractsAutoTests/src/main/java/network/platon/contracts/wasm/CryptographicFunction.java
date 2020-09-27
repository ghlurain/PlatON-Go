package network.platon.contracts.wasm;

import com.alaya.abi.wasm.WasmFunctionEncoder;
import com.alaya.abi.wasm.datatypes.WasmFunction;
import com.alaya.crypto.Credentials;
import com.alaya.protocol.Web3j;
import com.alaya.protocol.core.RemoteCall;
import com.alaya.rlp.wasm.datatypes.WasmAddress;
import com.alaya.tx.TransactionManager;
import com.alaya.tx.WasmContract;
import com.alaya.tx.gas.GasProvider;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.alaya.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.2.0.
 */
public class CryptographicFunction extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000013d0b60027f7f0060037f7f7f0060017f017f60000060017f0060027f7f017f60037f7f7f017f60047f7f7f7f017f60047f7f7f7f006000017f60017f017e02f5010b03656e7610706c61746f6e5f65637265636f766572000703656e7610706c61746f6e5f726970656d64313630000103656e760d706c61746f6e5f736861323536000103656e760c706c61746f6e5f70616e6963000303656e760d726c705f6c6973745f73697a65000203656e760f706c61746f6e5f726c705f6c697374000103656e760e726c705f62797465735f73697a65000503656e7610706c61746f6e5f726c705f6279746573000103656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000903656e7610706c61746f6e5f6765745f696e707574000403656e760d706c61746f6e5f72657475726e0000032221030101000102060302070104000a020005020400060003020005000003020208000405017001030305030100020608017f0141e088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000b0f5f5f66756e63735f6f6e5f65786974002106696e766f6b6500120908010041010b020d0f0aac3021040010270b370020004200370000200041106a4100360000200041086a4200370000200120022802002201200228020420016b41ff0171200010001a0b2c00200041003602082000420037020020004114100e20022802002201200228020420016b200028020010010bfd0101067f024020002802042202200028020022046b220520014904402000280208220720026b200120056b22034f04400340200241003a00002000200028020441016a22023602042003417f6a22030d000c030b000b2001200720046b2202410174220420042001491b41ffffffff07200241ffffffff03491b220104402001101021060b200520066a220521020340200241003a0000200241016a21022003417f6a22030d000b200120066a210420052000280204200028020022066b22016b2103200141014e044020032006200110111a0b2000200436020820002002360204200020033602000f0b200520014d0d002000200120046a3602040b0b2c00200041003602082000420037020020004120100e20022802002201200228020420016b200028020010020b0b002000410120001b10130bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bc20a020a7f027e230041d0026b22002400102710082201101322021009200041206a200020022001411c1014220341001015200041206a1016024002402000280224450d00200041206a10160240200028022022022c0000220141004e044020010d010c020b200141807f460d00200141ff0171220441b7014d0440200028022441014d04401003200028022021020b20022d00010d010c020b200441bf014b0d012000280224200141ff017141ca7e6a22014d04401003200028022021020b200120026a2d0000450d010b2000280224450d0020022d000041c001490d010b10030b20004180016a200041206a1017200028028401220141094f044010030b20002802800121020340200104402001417f6a21012002310000200a42088684210a200241016a21020c010b0b02400240200a500d004180081018200a510440200310194101460d020c010b4185081018200a510440200041386a4200370300200041306a4200370300200041286a420037030020004200370320200041003602482000420037034020031019410347044010030b200041406b2102200041e8016a200341011015200041e8016a1016200041b8016a200041e8016a101720002802bc0121010240024020002802ec01450d00200141204b0d0020002802e8012d000041c001490d010b10030b20004198016a2204420037030020004190016a2205420037030020004188016a22074200370300200042003703800120002001412020014120491b22016b41a0016a20002802b801200110111a200041286a22012007290300370300200041306a22062005290300370300200041386a220820042903003703002000200029038001220a3703502000200a37032020004180016a20034102101520004180016a2002101a200041d8006a22092001290300370300200041e0006a22012006290300370300200041e8006a2206200829030037030020002000290320370350200041f0006a2002101b21032004200629030037030020052001290300370300200720092903003703002000200029035037038001200041a0016a20004180016a2003100c200041b8016a101c2105200041e0016a200041b0016a2802002202360200200041d8016a200041a8016a290300220a3703004100210120004180026a4100360200200041f8016a4200370300200041f0016a4200370300200020002903a001220b3703d001200042003703e80120004190026a200a37030020004198026a2002360200200041a8026a200a370300200041b0026a20023602002000200b370388022000200b3703a002200041c8026a2002360200200041c0026a200a3703002000200b3703b802410121040240034020014114460d01200041b8026a20016a2102200141016a210120022d0000450d000b411521040b200020043602e801200041e8016a410472101d20052004101e20004198026a200041b0016a280200220136020020004190026a200041a8016a290300220a370300200020002903a001220b37038802200041a8026a200a370300200041b0026a2001360200200041c0026a200a370300200041c8026a20013602002000200b3703a0022000200b3703b802200041f8016a2001360200200041f0016a200a3703002000200b3703e8012005200041e8016a4114101f220128020c200141106a28020047044010030b20012802002001280204100a200128020c22020440200120023602100b200328020022010440200320013602040b20002802402201450d02200020013602440c020b419b081018200a5104402003410110200c020b41b1081018200a520d002003410210200c010b10030b1021200041d0026a24000b9b0101047f230041106b220124002001200036020c2000047f41d808200041086a2202411076220041d8082802006a220336020041d40841d408280200220420026a41076a417871220236020002400240200341107420024d044041d808200341016a360200200041016a21000c010b2000450d010b200040000d0010030b20042001410c6a4104101141086a0541000b2100200141106a240020000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000102820024f0d002003410471044010030c010b200042003702000b02402003411071450d002000102820024d0d0020034104710440100320000f0b200042003702000b20000bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001102320012003280208200328020c102436020c200320011023410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b200020062802002004411410141a200341106a24000f0b20032001102341002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b21052001200436021420012005360210200320064100200520041024102a2001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010030b0240200028020022012d0000418101470d00200028020441014d047f100320002802000520010b2c00014100480d0010030b0bd50101047f200110222204200128020422024b04401003200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a20001023200128020c210003402000450d01200141002001280208220320032000102422046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020bcb0101037f230041206b22022400024002402000280204044020002802002d000041c001490d010b20024100360208200242003703000c010b200241186a2000101720022802182103200241106a20001017200228021021042000102221002002410036020820024200370300200020046a20036b2200450d0020022000102520004101480d002002200228020420032000101120006a3602040b2001280200044020014100360208200142003702000b2001200228020036020020012002290204370204200241206a24000b5a01017f20004200370200200041003602080240200128020420012802006b2202450d002000200210252001280204200128020022026b22014101480d0020002802042002200110111a2000200028020420016a3602040b20000b29002000410036020820004200370200200041001026200041146a41003602002000420037020c20000b860201067f200028020422032000280210220141087641fcffff07716a2102027f200320002802082204460440200041146a210641000c010b2003200028021420016a220541087641fcffff07716a280200200541ff07714102746a2105200041146a21062002280200200141ff07714102746a0b21010340024020012005460440200641003602000340200420036b41027522014103490d022000200341046a22033602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2001417f6a220241014d04402000418004418008200241016b1b3602100b03402003200447044020002004417c6a22043602080c010b0b0b1300200028020820014904402000200110260b0b9c0101017f2000200120021006200028020422036a102b20012002200320002802006a10070340024020002802102201200028020c460d00200141786a2802004504401003200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210046a102b200120002802006a22012002200110050c010b0b20000b8e0301057f230041f0006b22022400200241003602102002420037030820001019410247044010030b200241d0006a200041011015200241d0006a200241086a101a200241286a2002200241186a200241086a101b22052001110100200241386a101c2101200241e8006a4100360200200241e0006a4200370300200241d8006a420037030020024200370350024020022802282204200228022c2206460440410121000c010b410121000240200620046b2203410146044020042c0000417f4a0d020c010b20034138490d00200620046b41016a210003402003450d02200041016a2100200341087621030c000b000b200341016a21000b20022000360250200241d0006a410472101d20012000101e200120022802282203200228022c20036b101f220328020c200341106a28020047044010030b20032802002003280204100a200328020c22000440200320003602100b2002280228220304402002200336022c0b200528020022030440200520033602040b2002280208220304402002200336020c0b200241f0006a24000b880101037f41c408410136020041c8082802002100034020000440034041cc0841cc082802002201417f6a2202360200200141014845044041c4084100360200200020024102746a22004184016a280200200041046a28020011040041c408410136020041c80828020021000c010b0b41cc08412036020041c808200028020022003602000c010b0b0bff0201037f200028020445044041000f0b2000101641012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100320002802040520010b4102490d0020002802002d00010d0010030b200241054f044010030b20002802002d000145044010030b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100320002802040520010b4102490d0020002802002d00010d0010030b200241054f044010030b20002802002d000145044010030b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10030b20020b2101017f20011022220220012802044b044010030b20002001200110292002102a0b2701017f230041206b22022400200241086a200020014114101410282100200241206a240020000b2001017f2000200110102202360200200020023602042000200120026a3602080b2f01017f2000280208200149044020011013200028020020002802041011210220002001360208200020023602000b0b3501017f230041106b220041e0880436020c41d008200028020c41076a417871220036020041d408200036020041d8083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001029200010226a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b3601017f2000280208200149044020011013200028020020002802041011210220002001360208200020023602000b200020013602040b0b4a01004180080b43696e69740063616c6c5f706c61746f6e5f65637265636f7665720063616c6c5f706c61746f6e5f726970656d643136300063616c6c5f706c61746f6e5f736861323536";

    public static String BINARY = BINARY_0;

    public static final String FUNC_CALL_PLATON_ECRECOVER = "call_platon_ecrecover";

    public static final String FUNC_CALL_PLATON_RIPEMD160 = "call_platon_ripemd160";

    public static final String FUNC_CALL_PLATON_SHA256 = "call_platon_sha256";

    protected CryptographicFunction(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected CryptographicFunction(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<CryptographicFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CryptographicFunction.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<CryptographicFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CryptographicFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<CryptographicFunction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CryptographicFunction.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<CryptographicFunction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(CryptographicFunction.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<WasmAddress> call_platon_ecrecover(byte[] hash, byte[] signature) {
        final WasmFunction function = new WasmFunction(FUNC_CALL_PLATON_ECRECOVER, Arrays.asList(hash,signature), WasmAddress.class);
        return executeRemoteCall(function, WasmAddress.class);
    }

    public RemoteCall<byte[]> call_platon_ripemd160(byte[] data) {
        final WasmFunction function = new WasmFunction(FUNC_CALL_PLATON_RIPEMD160, Arrays.asList(data, Void.class), byte[].class);
        return executeRemoteCall(function, byte[].class);
    }

    public RemoteCall<byte[]> call_platon_sha256(byte[] data) {
        final WasmFunction function = new WasmFunction(FUNC_CALL_PLATON_SHA256, Arrays.asList(data, Void.class), byte[].class);
        return executeRemoteCall(function, byte[].class);
    }

    public static CryptographicFunction load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new CryptographicFunction(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static CryptographicFunction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new CryptographicFunction(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
