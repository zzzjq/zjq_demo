package zjq.test.http.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程不安全写
 * 
 * @author:zhangjq
 * @time:2018年3月7日 下午4:09:53
 * @version:v1.0
 */
public class UnsafeWrite implements Runnable {

	private String msg;

	public UnsafeWrite(String msg) {
		this.msg = msg;
	}

	public static void main(String args[]) throws IOException {
		UnsafeWrite w1 = new UnsafeWrite("123");
		UnsafeWrite w2 = new UnsafeWrite("456");
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.submit(w1);
		e.submit(w2);
	}

	@Override
	public void run() {
		File file = new File("/Users/idealife/zjq/UnsafeWrite.txt");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(this.msg.getBytes("utf-8"));
		} catch (Exception e) {
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
