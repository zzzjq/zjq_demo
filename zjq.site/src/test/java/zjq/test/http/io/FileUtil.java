package zjq.test.http.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * 
 * @author zhangjq
 * @date 下午3:39:39
 *
 **/
public class FileUtil {


	/**
	 * 将list字符串写成字节流，并base64编码
	 * @param list
	 * @return
	 */
	public static String writeToBase64String(List<String> list) {
		if (list == null || list.size() < 1) {
			return "";
		}
		ByteArrayOutputStream out = null;
		String result = null;
		try {
			out = new ByteArrayOutputStream();
			for (String str : list) {
				out.write(str.getBytes("utf-8"));
				String newLine = System.getProperty("line.separator");
				out.write(newLine.getBytes());
			}
			result = new String(Base64.getEncoder().encode(out.toByteArray()), "utf-8");
		} catch (Exception e) {

		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
		return result;
	}
	
	/**
	 * 读取base64编码后的字节流
	 * @param msg
	 */
	public static String readBase64String(String msg){
		if(msg == null || msg.length() < 1) {
			return null;
		}	
		ByteArrayInputStream in = null;
		StringBuffer sb = new StringBuffer();
		try {
			byte[] b = Base64.getDecoder().decode(msg.getBytes("utf-8"));
			in = new ByteArrayInputStream(b);
			int len;
			byte[] buf = new byte[1024];
			while((len = in.read(buf)) != -1) {
				sb.append(new String(buf));
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<>();
		list.add("111|222|333");
		list.add("222|333|444");
		list.add("OK");
		System.out.println(writeToBase64String(list));
	} 

}
