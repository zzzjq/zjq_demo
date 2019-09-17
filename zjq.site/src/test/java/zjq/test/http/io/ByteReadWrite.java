package zjq.test.http.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * ByteArrayInputStream/ByteArrayOutputStream
 * 
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
	public static void writeFile(String fileData, String filepath) {
		try (ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(fileData));
				FileOutputStream out = new FileOutputStream(new File(filepath));) {
			int len = 0;
			byte[] bt = new byte[1024];
			while ((len = in.read(bt)) != -1) {
				out.write(bt, 0, len);
			}
		} catch (Exception e) {
		}
	}

	/****
	 * 从本地读取文件并编码
	 * 
	 * @param filepath
	 * @return
	 */
	public static String readFile(String filepath) {
		if (filepath == null || "".equals(filepath.trim()))
			return null;
		String result = null;
		try (FileInputStream in = new FileInputStream(new File(filepath));
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			int len = 0;
			byte[] bt = new byte[1024];
			while ((len = in.read(bt)) != -1) {
				out.write(bt, 0, len);
			}
			result = new String(Base64.getEncoder().encode(out.toByteArray()), "utf-8");
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 将list字符串写成字节流，并base64编码
	 * 
	 * @param list
	 * @return
	 */
	public static String writeToBase64String(List<String> list) {
		if (list == null || list.size() < 1)
			return null;
		String result = null;
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			for (String str : list) {
				out.write(str.getBytes("utf-8"));
				String newLine = System.getProperty("line.separator");
				out.write(newLine.getBytes());
			}
			result = new String(Base64.getEncoder().encode(out.toByteArray()), "utf-8");
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 读取base64编码后的字节流
	 * 
	 * @param msg
	 */
	public static String read(String msg) {
		if (msg == null || msg.length() == 0)
			return null;
		byte[] b = Base64.getDecoder().decode(msg.getBytes());
		StringBuffer sb = new StringBuffer();
		try (ByteArrayInputStream in = new ByteArrayInputStream(b)) {
			byte[] buf = new byte[1024];
			while (in.read(buf) != -1) {
				sb.append(new String(buf));
			}
			//单个读取
//			int len;
//			while ((len = in.read()) != -1) {
//				System.out.println((char)len);
//			}
		} catch (Exception e) {
		}
		return sb.toString();
	}

	/**
	 * 字符读
	 * 
	 * @param msg
	 * @return
	 */
	public static String reader(String msg) {
		if (null == msg || msg.length() == 0)
			return null;
		byte[] buf = Base64.getDecoder().decode(msg.getBytes());
		StringBuffer sb = new StringBuffer();
		String str = null;
		try (ByteArrayInputStream in = new ByteArrayInputStream(buf);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
			while ((str = reader.readLine()) != null) {
				sb.append(str);
				String newLine = System.getProperty("line.separator");
				sb.append(newLine);
			}
			// 单个读取
//			int len;
//			while((len = reader.read()) != -1) {
//				System.out.println((char)len);
//			}
			return sb.toString();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 字符读取文件
	 * 
	 * @param path
	 * @return
	 */
	public static String readeline(String path) {
		if (path == null || "".equals(path.trim()))
			return null;
		StringBuffer sb = new StringBuffer();
		String str = null;
		try (FileInputStream in = new FileInputStream(new File(path));
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<>();
		list.add("111|222|333");
		list.add("222|333|444");
		list.add("OK");
		String result = writeToBase64String(list);
		System.out.println(result);
		Thread.sleep(1000L);
		System.out.println(read(result));
		System.out.println(readeline("/Users/idealife/zjq/read.txt"));
	}

}
