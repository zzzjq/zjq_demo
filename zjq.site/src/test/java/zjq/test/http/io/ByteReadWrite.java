package zjq.test.http.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * byte[]流读写文件，base64编码
 * @author zhangjq
 * @date 2018年5月3日 上午10:56:03
 *
 **/
public class ByteReadWrite {

	/**
	 * 写文件到本地
	 * 
	 * @param fileDate-base64编码后的文件字符串
	 * @param fileName
	 */
	public static void writeFile(String fileData, String fileName, String filepath) {
		ByteArrayInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new ByteArrayInputStream(Base64.getDecoder().decode(fileData));
			out = new FileOutputStream(new File(filepath + fileName));
			int len = 0;
			byte[] bt = new byte[1024];
			while ((len = in.read(bt)) != -1) {
				out.write(bt, 0, len);
			}
		} catch (Exception e) {
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/****
	 * 从本地读取合同文件
	 * 
	 * @param filepath
	 * @return
	 */
	public static String readFile(String filepath) {
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		String result = null;
		try {
			in = new FileInputStream(new File(filepath));
			out = new ByteArrayOutputStream();
			int len = 0;
			byte[] bt = new byte[1024];
			while ((len = in.read(bt)) != -1) {
				out.write(bt, 0, len);
			}
			result = new String(Base64.getEncoder().encode(out.toByteArray()));
		} catch (Exception e) {

		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 将list字符串写成字节流，并base64编码
	 * @param list
	 * @return
	 */
	public static String writeToBase64String(List<String> list) {
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
	public static String read(String msg){
		if(msg == null || msg.length() < 1) {
			return null;
		}
		byte[] b = Base64.getDecoder().decode(msg.getBytes());
		ByteArrayInputStream in = null;
		StringBuffer sb = new StringBuffer();
		try {
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

}
