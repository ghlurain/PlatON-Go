package network.platon.contracts.wasm;

import com.alaya.abi.wasm.WasmFunctionEncoder;
import com.alaya.abi.wasm.datatypes.WasmFunction;
import com.alaya.crypto.Credentials;
import com.alaya.protocol.Web3j;
import com.alaya.protocol.core.RemoteCall;
import com.alaya.rlp.wasm.datatypes.Uint32;
import com.alaya.rlp.wasm.datatypes.Uint64;
import com.alaya.rlp.wasm.datatypes.Uint8;
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
public class TypeConversionContract extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001591060017f017f60027f7f0060017f0060037f7f7f017f60037f7f7f0060000060027f7f017f60047f7f7f7f017f60047f7f7f7f0060027f7e0060017f017e60037e7e7f006000017f60027f7e017f60017e017f60027e7e017f02a9020d03656e760c706c61746f6e5f70616e6963000503656e760d726c705f6c6973745f73697a65000003656e760f706c61746f6e5f726c705f6c697374000403656e760e726c705f62797465735f73697a65000603656e7610706c61746f6e5f726c705f6279746573000403656e760d726c705f753132385f73697a65000f03656e760f706c61746f6e5f726c705f75313238000b03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000603656e7610706c61746f6e5f6765745f7374617465000703656e7610706c61746f6e5f7365745f7374617465000803656e760d706c61746f6e5f72657475726e000103464505000000050003040a0a020002000002000902010d01010507020001090007010203000002060603040102000e0101000103010202010301010001030702030404050000080405017001040405030100020608017f0141a089040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000d0f5f5f66756e63735f6f6e5f65786974002406696e766f6b6500110909010041010b030e0f100a9a5b450400104e0b050041ea010b050041f4010b0400410a0bf90402047f017e23004180016b22002400104e10072201101222021008200041d8006a200041086a20022001101322014100101402400240200041d8006a10152204500d004180081016200451044020011017200041d8006a101810190c020b418508101620045104402001101a410347044010000b200041d8006a200141011014200041d8006a101b2102200041d8006a200141021014200041d8006a10152104200041d8006a10182101200020042002ad7c370338200041386a101c200110190c020b418d08101620045104402001101a410247044010000b200041d8006a200141011014200041d8006a101b2101200041d8006a1018210220002001410047ad370338200041386a101c200210190c020b41a1081016200451044020011017200041d8006a10182102200041206a101d2101200041d0006a4100360200200041c8006a4200370300200041406b420037030020004200370338200041386a4201101e20002802382103200041386a410472101f200120031020200142011021220128020c200141106a28020047044010000b20012802002001280204100c200128020c22030440200120033602100b200210190c020b41af0810162004510440200041003b0020200041216a21022001101a410347044010000b20004101360238200020013602582000200041386a36025c200041d8006a200041206a1022200041d8006a20021022200041d8006a101821012000200031002120003100207c370338200041386a101c200110190c020b41bf08101620045104402001410110230c020b41cb08101620045104402001410210230c020b41e30810162004520d002001410310230c010b10000b102420004180016a24000b9b0101047f230041106b220124002001200036020c2000047f419009200041086a220241107622004190092802006a2203360200418c09418c09280200220420026a41076a417871220236020002400240200341107420024d0440419009200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104103e41086a0541000b2100200141106a240020000b0c00200020012002411c10250bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001104220012003280208200328020c103336020c200320011042410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b200020062802002004411410251a200341106a24000f0b20032001104241002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004103310512001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b850102027f017e230041106b22012400200010260240024020001027450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001028200128020c220041094f044010000b200128020821020340200004402000417f6a210020023100002003420886842103200241016a21020c010b0b200141106a240020030b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b0e002000101a410147044010000b0b900a010f7f230041a0016b22032400200042003702182000428debc585c3a7f9dbf7003703102000410036020820004200370200200041206a4100360200200341206a101d220820002903101029200828020c200841106a28020047044010000b200041186a21062000411c6a2109024020082802002205200828020422041009220a450d00200a102a21020340200120026a41003a0000200a200141016a2201470d000b2005200420022001100a417f460440410021010c010b02400240200341086a200241016a200120026a2002417f736a10132201280204450d0020012802002d000041c001490d002001101a21022000280220200028021822056b410c6d20024904402006200341c8006a2002200028021c20056b410c6d200041206a102b2202102c2002102d0b200341f0006a20014101102e2104200341e0006a20014100102e210c200041206a210d2004280204210120034188016a410172210e0340200c280204200146410020042802082202200c280208461b0d02200341c8006a20012002411c10252101200341386a102f210b02400240200328024c044020032802482d000041c001490d010b20034188016a102f1a0c010b20034180016a20011028200110302102024002400240024020032802800122010440200328028401220520024f0d010b4100210120034190016a4100360200200342003703880141002107410021050c010b20034190016a410036020020034200370388012001200520022002417f461b22076a21052007410a4b0d010b200320074101743a008801200e21020c010b200741106a417071220f102a21022003200736028c012003200f4101723602880120032002360290010b03402001200546450440200220012d00003a0000200241016a2102200141016a21010c010b0b200241003a00000b024020032d0038410171450440200341003b01380c010b200328024041003a00002003410036023c20032d0038410171450d00200341003602380b200341406b220220034190016a280200360200200320032903880137033820034188016a10310240200028021c2201200028022049044020012003290338370200200141086a2002280200360200200b103120092009280200410c6a3602000c010b20034188016a2006200120062802006b410c6d220141016a10322001200d102b210120032802900122052003290338370200200541086a2002280200360200200b10312003200328029001410c6a3602900120062001102c2001102d0b20042004280204220120042802086a410020011b22013602042004280200220204402004200236020820012002103321052004027f2004280204220b4504404100210241000c010b410021024100200428020822072005490d001a200720052005417f461b2102200b0b2201ad2002ad42208684370204200441002004280200220520026b2202200220054b1b3602000c0105200441003602080c010b000b000b10000b200a21010b200828020c22020440200820023602100b024020010d0020002802042205200028020022026b410c6d22042000280220200028021822016b410c6d4d04402004200928020020016b410c6d220a4b044020022002200a410c6c6a2204200110341a20042005200910350c020b2006200220052001103410360c010b200104402006103720004100360220200042003702180b20002006200410322204103822013602182000200136021c200020012004410c6c6a36022020022005200910350b200341a0016a240020000ba008010b7f230041e0006b22032400200341186a101d2208200029031010391020200820002903101029200828020c200841106a28020047044010000b2008280204210a2008280200210b2003101d2101200341c8006a4100360200200341406b4200370300200341386a420037030020034200370330027f20002802182000411c6a2802004604402003410136023041010c010b200341306a4100103a200341d0006a4101722109200028021c210720002802182102037f2002200746047f200341306a4101103a200328023005200341d0006a2002103b41012105024002400240200328025420032d00502204410176200441017122061b220441014d0440200441016b0d032003280258200920061b2c0000417f4c0d010c030b200441374b0d010b200441016a21050c010b2004103c20046a41016a21050b027f200341306a20032802482204450d001a2003280238200420032802446a417f6a220441087641fcffff07716a280200200441ff07714102746a0b2204200428020020056a3602002002410c6a21020c010b0b0b2106200341306a410472101f4101102a220241fe013a0000200128020c200141106a28020047044010000b200241016a21052001280204220441016a220720012802084b047f20012007103d20012802040520040b20012802006a20024101103e1a2001200128020441016a3602042001200620026b20056a10200240200028021c20002802186b220204402002410c6d21022001280204210420012802102205200141146a280200220649044020052002ad2004ad422086843702002001200128021041086a3602100c020b027f41002005200128020c22076b410375220941016a2205200620076b2206410275220720072005491b41ffffffff01200641037541ffffffff00491b2207450d001a2007410374102a0b2105200520094103746a22062002ad2004ad4220868437020020062001280210200128020c22096b22026b2104200520074103746a2105200641086a2106200241014e0440200420092002103e1a0b20012005360214200120063602102001200436020c0c010b200141001001200128020422026a103f41004100200220012802006a1002200110400b200341306a4101722109200028021c210720002802182102034020022007470440200341306a2002103b20012003280238200920032d0030220441017122051b22062003280234200441017620051b22041003200128020422056a103f20062004200520012802006a1004200110402002410c6a21020c010b0b0240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b200b200a20022001280204100b200128020c22020440200120023602100b200828020c22010440200820013602100b200041186a104120001041200341e0006a24000b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a20001042200128020c210003402000450d01200141002001280208220320032000103322046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020b7d01037f230041106b22012400200010260240024020001027450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001028200128020c220041024f044010000b200128020821020340200004402000417f6a210020022d00002103200241016a21020c010b0b200141106a240020030b5f01027f230041206b22022400200241086a101d2201200029030010391020200120002903001029200128020c200141106a28020047044010000b20012802002001280204100c200128020c22000440200120003602100b200241206a24000b2900200041003602082000420037020020004100103d200041146a41003602002000420037020c20000b840102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002103c20026a0520020b41016a21030b200041186a28020022020440200041086a280200200041146a2802002002104321000b2000200028020020036a3602000bea0101047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a20001044200428020c210203400240200120024604402000410036021420002802082103200028020421010340200320016b41027522024103490d022000200141046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b200020011045200441106a24000b13002000280208200149044020002001103d0b0b2a01017f2000420020011005200028020422026a103f42002001200220002802006a10062000104020000b4601017f230041206b22022400200241086a2000280200200028020428020010142001200241086a101b3a000020002802042200200028020041016a360200200241206a24000bb90102027f017e230041e0006b2202240020001017200210182103200220011100002100200241286a101d2101200241d8006a4100360200200241d0006a4200370300200241c8006a420037030020024200370340200241406b2000ad2204101e20022802402100200241406b410472101f200120001020200120041021220128020c200141106a28020047044010000b20012802002001280204100c200128020c22000440200120003602100b20031019200241e0006a24000b880101037f41fc084101360200418009280200210003402000044003404184094184092802002201417f6a2202360200200141014845044041fc084100360200200020024102746a22004184016a280200200041046a28020011020041fc08410136020041800928020021000c010b0b4184094120360200418009200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104f20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104f20024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001026200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd50101047f200110302204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b09002000200110211a0b0b002000410120001b10120b4c01017f2000410036020c200041106a2003360200200104402001103821040b20002004360200200020042002410c6c6a2202360208200020042001410c6c6a36020c2000200236020420000baa0101037f200028020421022000280200210303402002200346450440200128020441746a2204200241746a2202290200370200200441086a200241086a280200360200200210312001200128020441746a3602040c010b0b200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2b01027f20002802082101200028020421020340200120024704402000200141746a22013602080c010b0b0be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001104220004100200428020c2201200428020822022001103322032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b190020004200370200200041086a41003602002000103120000bff0201037f200028020445044041000f0b2000102641012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b3101017f2001200028020820002802006b410c6d2200410174220220022001491b41d5aad5aa01200041aad5aad500491b0b2701017f230041206b22022400200241086a2000200141141025104f2100200241206a240020000bd00201077f200120006b2108410021010340200120026a2105200120084645044002402005200020016a2203460d00200341046a28020020032d00002204410176200441017122071b2104200341016a2106200341086a2802002109410a21032009200620071b210720052d0000410171220604402005280200417e71417f6a21030b200420034d0440027f20060440200541086a2802000c010b200541016a0b210320040440200320072004104c0b200320046a41003a000020052d00004101710440200541046a20043602000c020b200520044101743a00000c010b416f2106200341e6ffffff074d0440410b20034101742203200420042003491b220341106a4170712003410b491b21060b2006102a220320072004104d200541046a200436020020052006410172360200200541086a2003360200200320046a41003a00000b2001410c6a21010c010b0b20050b2d000340200020014645044020022802002000103b20022002280200410c6a3602002000410c6a21000c010b0b0b0900200020013602040b0b002000200028020010360b09002000410c6c102a0b4f01027f230041206b22012400200141186a4100360200200141106a4200370300200141086a42003703002001420037030020012000101e200128020021022001410472101f200141206a240020020bc10c02077f027e230041306b22042400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022031043280200210120022003417f6a360200200710464180104f044020072000410c6a280200417c6a10450b200141384f047f2001103c20016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002104321000c010b0240200710460d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021032001200241046a360200200420033602182007200441186a10470c010b2000410c6a2802002202200041086a2802006b4102752203200041106a2205280200220620002802046b2201410275490440418020102a2105200220064704400240200028020c220120002802102202470d0020002802082203200028020422064b04402000200320012003200320066b41027541016a417e6d41027422026a1048220136020c2000200028020820026a3602080c010b200441186a200220066b2201410175410120011b22012001410276200041106a10492102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002104a200028020c21010b200120053602002000200028020c41046a36020c0c020b02402000280208220120002802042202470d00200028020c2203200028021022064904402000200120032003200620036b41027541016a41026d41027422026a104b22013602082000200028020c20026a36020c0c010b200441186a200620026b2201410175410120011b2201200141036a410276200041106a10492102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002104a200028020821010b2001417c6a2005360200200020002802082201417c6a22023602082002280200210220002001360208200420023602182007200441186a10470c010b20042001410175410120011b2003200510492102418020102a2106024020022802082201200228020c2203470d0020022802042205200228020022084b04402002200520012005200520086b41027541016a417e6d41027422036a104822013602082002200228020420036a3602040c010b200441186a200320086b2201410175410120011b22012001410276200241106a280200104921032002280208210520022802042101034020012005470440200328020820012802003602002003200328020841046a360208200141046a21010c010b0b2002290200210920022003290200370200200320093702002002290208210920022003290208370208200320093702082003104a200228020821010b200120063602002002200228020841046a360208200028020c2105034020002802082005460440200028020421012000200228020036020420022001360200200228020421012002200536020420002001360208200029020c21092000200229020837020c200220093702082002104a052005417c6a210502402002280204220120022802002203470d0020022802082206200228020c22084904402002200120062006200820066b41027541016a41026d41027422036a104b22013602042002200228020820036a3602080c010b200441186a200820036b2201410175410120011b2201200141036a4102762002280210104921062002280208210320022802042101034020012003470440200428022020012802003602002004200428022041046a360220200141046a21010c010b0b20022902002109200220042903183702002002290208210a20022004290320370208200420093703182004200a3703202006104a200228020421010b2001417c6a200528020036020020022002280204417c6a3602040c010b0b0b200441186a20071044200428021c4100360200200041186a2100410121010b2000200028020020016a360200200441306a24000b9d0101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a2802003602000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204102a21022000200136020420002004410172360200200020023602080b200220032001104d200120026a41003a00000b1e01017f03402000044020004108762100200141016a21010c010b0b20010b2f01017f200028020820014904402001101220002802002000280204103e210220002001360208200020023602000b0bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b3601017f200028020820014904402001101220002802002000280204103e210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210016a103f200120002802006a22012002200110020c010b0b0b0e0020002802000440200010370b0b2101017f20011030220220012802044b044010000b2000200120011050200210510b25002000200120026a417f6a220241087641fcffff07716a280200200241ff07714102746a0b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2203470d0020002802042204200028020022064b04402000200420022004200420066b41027541016a417e6d41027422036a104822023602082000200028020420036a3602040c010b200541086a200320066b2202410175410120021b220220024102762000410c6a10492103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b2000290200210720002003290200370200200320073702002000290208210720002003290208370208200320073702082003104a200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b2201410275210320010440200220002001104c0b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274102a21040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b220220002001104c0b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002103e1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b100020020440200020012002103e1a0b0b3501017f230041106b220041a0890436020c418809200028020c41076a4178712200360200418c0920003602004190093f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001050200010306a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b800101004180080b79696e6974006765745f616464006765745f646966666572656e745f747970655f006765745f7072616d5f74797065006765745f7072616d5f72657475726e006765745f636f6e76657274006765745f636f6e766572745f7374617469635f63617374006765745f636f6e766572745f636f6e73745f63617374";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GET_ADD = "get_add";

    public static final String FUNC_GET_DIFFERENT_TYPE_ = "get_different_type_";

    public static final String FUNC_GET_PRAM_TYPE = "get_pram_type";

    public static final String FUNC_GET_PRAM_RETURN = "get_pram_return";

    public static final String FUNC_GET_CONVERT = "get_convert";

    public static final String FUNC_GET_CONVERT_STATIC_CAST = "get_convert_static_cast";

    public static final String FUNC_GET_CONVERT_CONST_CAST = "get_convert_const_cast";

    protected TypeConversionContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected TypeConversionContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<TypeConversionContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(TypeConversionContract.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<TypeConversionContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(TypeConversionContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<TypeConversionContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(TypeConversionContract.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<TypeConversionContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(TypeConversionContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<Uint64> get_add(Uint8 a, Uint64 b) {
        final WasmFunction function = new WasmFunction(FUNC_GET_ADD, Arrays.asList(a,b), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<Uint64> get_different_type_(Boolean a) {
        final WasmFunction function = new WasmFunction(FUNC_GET_DIFFERENT_TYPE_, Arrays.asList(a), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<Uint32> get_pram_type() {
        final WasmFunction function = new WasmFunction(FUNC_GET_PRAM_TYPE, Arrays.asList(), Uint32.class);
        return executeRemoteCall(function, Uint32.class);
    }

    public RemoteCall<Uint64> get_pram_return(Uint8 a, Uint8 b) {
        final WasmFunction function = new WasmFunction(FUNC_GET_PRAM_RETURN, Arrays.asList(a,b), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<Uint8> get_convert() {
        final WasmFunction function = new WasmFunction(FUNC_GET_CONVERT, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public RemoteCall<Uint8> get_convert_static_cast() {
        final WasmFunction function = new WasmFunction(FUNC_GET_CONVERT_STATIC_CAST, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public RemoteCall<Uint8> get_convert_const_cast() {
        final WasmFunction function = new WasmFunction(FUNC_GET_CONVERT_CONST_CAST, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public static TypeConversionContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new TypeConversionContract(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static TypeConversionContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new TypeConversionContract(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
