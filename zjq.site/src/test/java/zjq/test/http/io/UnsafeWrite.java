package zjq.test.http.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author:zhangjq
 * @time:2018年3月7日 下午4:09:53
 * @version:v1.0
 */
public class UnsafeWrite {

	public static void main(String args[]) throws IOException{	
		//写文件线程不安全
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				FileOutputStream outputStream = null;
				try {
					File file = new File("/Users/idealife/2.txt");
					outputStream = new FileOutputStream(file);
					outputStream.write("111".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				FileOutputStream outputStream = null;
				try {
					File file = new File("/Users/idealife/2.txt");
					outputStream = new FileOutputStream(file);
					outputStream.write("222".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		thread2.start();
	}
}
