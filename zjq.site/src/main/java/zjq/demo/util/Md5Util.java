package zjq.demo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author:zhangjq
 * @time:2016年12月9日 下午2:06:25
 * @version:v1.0
 */
public class Md5Util {
	
	public static final char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	private static MessageDigest messageDigest = null;

	//小写字母
	public static String getMd5String(String str){
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());
			return new BigInteger(1	, messageDigest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//大写字母
	public static String getNewMd5String(String str){
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());
			return toHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String toHexString(byte[] b){
		StringBuffer sb = new StringBuffer(b.length * 2);
		for(int i=0;i<b.length;i++){
			sb.append(hexChar[(b[i] & 0xf0) >> 4]);
			sb.append(hexChar[b[i] & 0x0f]);
		}
		return sb.toString();
	}
	
	public static void main(String[] agrs){
		String aa = "116556";
		System.out.println(getMd5String(aa));
		System.out.println(getNewMd5String(aa));
	}
}