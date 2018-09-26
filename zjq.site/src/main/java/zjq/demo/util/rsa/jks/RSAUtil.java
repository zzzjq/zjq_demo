package zjq.demo.util.rsa.jks;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import zjq.demo.util.HexUtil;

/**
 * RSA签名验签
 * @author:zhangjq
 * @time:2017年7月7日 下午4:30:26
 * @version:v1.0
 */
public class RSAUtil {
	
	private static final String algname = "SHA1withRSA";

	private static final String keyalgname = "RSA";

	private RSAUtil() {
	}

	/**
	 * 具有私钥的签名算法
	 * 
	 * @param src
	 * @param usekey
	 * @param algname
	 * @return
	 * @throws Exception
	 */
	public static String genSignature(byte[] src, PrivateKey usekey)
			throws Exception {
		Signature signature = Signature.getInstance(algname);
		signature.initSign(usekey);
		signature.update(src);
		return HexUtil.toHexString(signature.sign());
	}
	
	/**
	 * 验签
	 */
	public static boolean verifySignature(byte[] src, String dest,
			PublicKey usekey) throws Exception {
		Signature signature = Signature.getInstance(algname);
		signature.initVerify(usekey);
		signature.update(src);
		return signature.verify(HexUtil.toByteArray(dest));
	}
}
