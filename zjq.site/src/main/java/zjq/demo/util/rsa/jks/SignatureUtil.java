package zjq.demo.util.rsa.jks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

import zjq.demo.util.HexUtil;

/**
 * @author:zhangjq
 * @time:2017年7月7日 下午3:37:14
 * @version:v1.0
 */
public class SignatureUtil {

	private SignatureUtil(){}
	
	static Map<String, String> map = new HashMap<String, String>();
	
	static final String gatewayKeyPath="gateway.keyPath";
	static final String gatewayStorepass="gateway.storepass";
	static final String gatewayAlias="gateway.alias";
	static final String gatewayPwd="gateway.pwd";
	static final String gatewayPublicKey="gateway.publicKey";
	
	static String webPropertiesPath = "other/zjq.properties";
//	static String windowsPropertiesPath = "D:\\gateway-security.propertes";
//	static String linuxPropertiesPath = "/opt/config/gateway-security.propertes";
	static String windowsFilePath = "D:\\";
	static String linuxFilePath = "/opt/config";
	
	static{
		Properties p = new Properties();
		try {
			//读项目里的配置
			p.load(SignatureUtil.class.getClassLoader().getResourceAsStream(webPropertiesPath));
			//读系统里的文件
			//p.load(new FileInputStream(windowsPropertiesPath));
			//map.put(gatewayKeyPath, windowsFilePath + p.getProperty(gatewayKeyPath) + "");
			map.put(gatewayKeyPath, p.getProperty(gatewayKeyPath) + "");
			map.put(gatewayStorepass, p.getProperty(gatewayStorepass) + "");
			map.put(gatewayAlias, p.getProperty(gatewayAlias) + "");
			map.put(gatewayPwd, p.getProperty(gatewayPwd) + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取公钥
	 * @param keyStoreFile  JKS文件
	 * @param storeFilePass keyStore密码
	 * @param keyAlias      alias名称
	 * @return
	 */
	public static PublicKey getPublicKey(String keyStoreFile, String storeFilePass,
			String keyAlias) {
		// 读取密钥是所要用到的工具类
		KeyStore ks;
		// 公钥类所对应的类
		PublicKey pubkey = null;
		try {
			// 得到实例对象
			ks = KeyStore.getInstance("JKS");
//			FileInputStream fin;
			// 读取JKS文件
//				fin = new FileInputStream(keyStoreFile);
			try {
				//读取本地文件
				InputStream fin = SignatureUtil.class.getClassLoader().getResourceAsStream(keyStoreFile);
				// 读取公钥
				ks.load(fin, storeFilePass.toCharArray());
				Certificate cert = ks.getCertificate(keyAlias);
				pubkey = cert.getPublicKey();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return pubkey;
	}
	
	
	/**
	  * 得到私钥
	  * 
	  * @param keyStoreFile
	  *            私钥文件
	  * @param storeFilePass
	  *            私钥文件的密码
	  * @param keyAlias
	  *            别名
	  * @param keyAliasPass
	  *            密码
	  * @return
	  */
	public static PrivateKey getPrivateKey(String keyStoreFile,
			String storeFilePass, String keyAlias, String keyAliasPass) {
		KeyStore ks;
		PrivateKey prikey = null;
		try {
			ks = KeyStore.getInstance("JKS");
			FileInputStream fin;
			try {
				fin = new FileInputStream(windowsFilePath + keyStoreFile);
				try {
					try {
						ks.load(fin, storeFilePass.toCharArray());
						// 先打开文件
						prikey = (PrivateKey) ks.getKey(keyAlias,
								keyAliasPass.toCharArray());
						// 通过别名和密码得到私钥
					} catch (UnrecoverableKeyException e) {
						e.printStackTrace();
					} catch (CertificateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return prikey;
	}
	
	public static void main(String[] args) throws Exception{
		//得到公钥（16进制）
		PublicKey key = getPublicKey(map.get(gatewayKeyPath),
				map.get(gatewayStorepass),
				map.get(gatewayAlias));
		System.out.println(key);
		byte[] bt = key.getEncoded();
		System.out.println(HexUtil.toHexString(bt));
		String publicKey = HexUtil.toHexString(bt);
		//得到私钥（16进制）
		PrivateKey prikey = getPrivateKey(map.get(gatewayKeyPath), 
				map.get(gatewayStorepass),
				map.get(gatewayAlias), 
				map.get(gatewayPwd));
		byte[] bt2 = prikey.getEncoded();
		String privateKey = HexUtil.toHexString(bt2);
		System.out.println("publicKey:" + publicKey);
		System.out.println("privateKey:" + privateKey);
		System.out.println("-----------下面是源信息-------------");
		System.out.println(key.toString());
		System.out.println(prikey.toString());
		//签名
		System.out.println("-----------生成签名信息-------------");
		String msg = "name=zjq&age=25";
		String signMsg = RSAUtil.genSignature(Base64.encodeBase64(msg.getBytes("utf-8")), prikey);
		System.out.println("签名结果：" + signMsg);
		//验签
		System.out.println("-----------验签-------------");
		String sign = "6297dea9fc9116b332528eb63b5ff1400edf9e8d078a7b32dbc2dd06122631c832fa8ff37af3720fe00ebe08dd8f01dcd8b3809044bdfec4da6e3cd1f4d7cc58949e546d435f50e03d7a5bc719ad309b96411660d89485e4434020e6c8af70d3f4f7229c2413092be6cf9fa823caefebd13f035b557110ff1b95e5787882d1ee9ae8a58be6c00a80ec27c2ea1f0ccab5c4e19b3555cdc16292e81bbbf7ae610128d5ca95ec2b1ec9ac12ba2a07ce93993ee2122f657be1c2bb28585f2f12439ce4eb29ea77addcb8d166b917e7959a64fb481727fde70a3cff26ea10df75333b11af709ae4d97117072ad7b79b94d9ef40d12493272bf72f9c98b021481ecf30";
		boolean bool = RSAUtil.verifySignature(Base64.encodeBase64(msg.getBytes("utf-8")), sign, key);
		System.out.println("验签结果：" + bool);
	}
	
}
