package zjq.test.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier可以重用，CountDownLatch不行
 * CyclicBarrier的await方法是每个线程里面都要执行等待；
 * CountDownLatch是主线程等待计数器为0
 * 
 * @author zhangjq
 * @date 2019年2月21日下午5:16:18
 *
 **/
public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier c = new CyclicBarrier(4);
		for (int i = 1; i <= 4; i++) {
			new Thread(new Worker(c)).start();
		}

		try {
			Thread.sleep(10000L);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("CyclicBarrier重用");

		for (int i = 1; i <= 4; i++) {
			new Thread(new Worker(c)).start();
		}
	}

	static class Worker implements Runnable {

		private CyclicBarrier c;

		public Worker(CyclicBarrier c) {
			this.c = c;
		}

		@Override
		public void run() {
			System.out.println("当前线程" + Thread.currentThread().getName() + "正在执行");
			try {
				Thread.sleep(3000L);
				System.out.println("当前线程" + Thread.currentThread().getName() + "执行完毕等待其余线程");
				c.await();
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("当前线程" + Thread.currentThread().getName() + "继续执行后续任务");
		}

	}
}
