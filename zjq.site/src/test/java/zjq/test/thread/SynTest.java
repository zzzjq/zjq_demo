package zjq.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynTest {
	public static void main(String args[]) {
		final AA a = new AA();

		new Thread(new Runnable() {

			public void run() {
//				try{
//					Thread.sleep(2000);
//				}catch(InterruptedException e){
//					e.printStackTrace();
//				}
				a.aa("12345");
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				a.aa("67890");
			}
		}).start();
	}
}
//用锁
class AA {
	private static Lock lock = new ReentrantLock();
	public void aa(String str) {
		try {
			lock.lock();
			for (int i = 0; i < str.length(); i++) {
				System.out.print(str.charAt(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
//用synchronized
class BB {
	public void bb(String str){
		synchronized(this){
			for (int i = 0; i < str.length(); i++) {
				System.out.print(str.charAt(i));
			}
		}
	}
}