package zjq.demo.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * DES加解密工具类
 * 
 * @author:zhangjq
 * @time:2017年7月6日 上午10:51:47
 * @version:v1.0
 */
public class DesUtil {

    // 密钥
    // 向量
    private final static String iv = "01234567";
    // 加解密统一使用的编码方式
    private final static String encoding = "utf-8";

    /**
     * 3DES加密
     * 
     * @param plainText
     *            普通文本
     * @return
     * @throws Exception
     */
    public static String encode(String plainText, String key) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return Base64.getEncoder().encodeToString(encryptData);
    }

    /**
     * 3DES解密
     * 
     * @param encryptText
     *            加密文本
     * @return
     * @throws Exception
     */
    public static String decode(String encryptText, String key) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] decryptData = cipher.doFinal(Base64.getDecoder().decode(encryptText));
        return new String(decryptData, encoding);
    }

    public static void main(String[] args) throws Exception {
        String str = "{\"header\":{\"seqNo\":\"39210830921\",\"applySerialNo\":\"39210830921\",\"success\":\"true\"},\"responseBody\":{\"loanApplyId\":\"123456\"}}";
        String encryptText = DesUtil.encode(str, "ZBVLQRSH94728561!~#$*&%@");
        System.out.println(encryptText);
        System.out.println(DesUtil.decode(encryptText, "ZBVLQRSH94728561!~#$*&%@"));
    }

}
