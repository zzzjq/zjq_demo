package zjq.demo.util.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * 公钥加密
 * @author:zhangjq
 * @time:2017年8月15日 下午6:42:53
 * @version:v1.0
 */
public class KeyUtil {
	
	/***
	 * 读取私钥
	 * 
	 * @param filePath
	 * @return
	 */
	public static PrivateKey getStoredPrivateKey(String filePath) {
		PrivateKey privateKey = null;
		byte[] keydata = getKey(filePath);
		PKCS8EncodedKeySpec encodedPrivateKey = new PKCS8EncodedKeySpec(keydata);
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			privateKey = keyFactory.generatePrivate(encodedPrivateKey);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}
	
	/**
	 * 读取公钥
	 * @param filePath
	 * @return
	 */
	public static PublicKey getStoredPublicKey(String filePath) {
        PublicKey publicKey = null;
        byte[] keydata = getKey(filePath);
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        X509EncodedKeySpec encodedPublicKey = new X509EncodedKeySpec(keydata);
        try {
            publicKey = keyFactory.generatePublic(encodedPublicKey);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }
	
	/**
	 * 读取密钥文件
	 * @param path
	 * @return
	 */
	public static byte[] getKey(String path) {
		FileInputStream in = null;
		File file = new File(path);
		byte[] buf = new byte[(int) file.length()];
		try {
			in = new FileInputStream(file);
			in.read(buf);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
	
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					
				}
		}
		return buf;
	}
	
	/**
	 * 读取私钥（byte格式）
	 * @param priKey
	 * @return
	 */
	public static PrivateKey getStoredPrivateKey(byte[] priKey) {
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec encodedPrivateKey = new PKCS8EncodedKeySpec(priKey);
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			privateKey = keyFactory.generatePrivate(encodedPrivateKey);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}
	
	/**
	 * 公钥加密
	 * @param key
	 * @param msg
	 * @return
	 */
	public static byte[] encrypt(PublicKey key, byte[] msg){
		Cipher cipher = null;
		try{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(msg);
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	/**
	 * 私钥解密
	 * @param key
	 * @param msg
	 * @return
	 */
	public static byte[] decrypt(PrivateKey key, byte[] content){
		Cipher cipher = null;
		try{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(content);
		}
		catch(Exception e){
			return null;
		}		
	}

}
