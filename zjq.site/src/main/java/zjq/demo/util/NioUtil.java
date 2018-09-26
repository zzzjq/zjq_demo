package zjq.demo.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO工具类，读写文件
 * @author:zhangjq
 * @time:2017年5月25日 下午2:29:01
 * @version:v1.0
 */
public class NioUtil {

	private static RandomAccessFile file = null;
	
	private static FileChannel channel = null;
	
	private static final ByteBuffer BUF = ByteBuffer.allocate(1024);
	
	/**
	 * 读取文件
	 * @param path
	 * @return
	 */
	public static String readFile(String path) {
		try {
			StringBuilder sb = new StringBuilder();
			file = new RandomAccessFile(path, "r");
			channel = file.getChannel();
			int len;
			while ((len = channel.read(BUF)) != -1) {
				BUF.flip();
				while (BUF.hasRemaining())
					sb.append((char) BUF.get());
				BUF.clear();
				len = channel.read(BUF);
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		} finally {
			try {
				channel.close();
				file.close();
			} catch (IOException e) {
			}

		}
	}
	
	/**
	 * 写文件
	 * @param path
	 * @param words
	 */
	public static void writeFile(String path, String words) {
		try {
			file = new RandomAccessFile(path, "rw");
			channel = file.getChannel();
			BUF.clear();
			BUF.put(words.getBytes());
			BUF.flip();
			while (BUF.hasRemaining())
				channel.write(BUF);
		} catch (Exception e) {

		} finally {
			try {
				channel.close();
				file.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println(readFile("F://write.txt"));
		writeFile("F://hello.txt", "hello nio test");
	}
}
