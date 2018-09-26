package zjq.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 线程计数器，设置两个线程，只有当两个线程跑完 才会执行下去
 * 
 * @author:zhangjq
 * @time:2016年12月1日 下午2:27:16
 * @version:v1.0
 */
public class ThreadControl {
	public static void main(String[] args) {
		//设置为2的计数器
		CountDownLatch count = new CountDownLatch(2);
		//对应两个线程
		Thread th1 = new Thread(new User(count, "JACK"));
		Thread th2 = new Thread(new User(count, "ROSE"));
		th1.start();
		th2.start();
		try {
			//计数器为空之前，一直等待
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Users:all above");
	}

	static class User implements Runnable {

		private String name;
		
		private CountDownLatch count;

		public User(CountDownLatch count, String name) {
			this.name = name;
			this.count = count;
		}

		@Override
		public void run() {
			System.out.println(name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				//计数器减掉1
				count.countDown();
			}
		}
	}
	
}
