package zjq.test.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author zhangjq
 * @date 2019年3月27日下午7:20:10
 *
 **/
public class CyclicBarrierTest2 {

	public static void main(String[] args) {
		CyclicBarrier c = new CyclicBarrier(4);
		for(int i=0; i<=4; i++) {
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
			try {
				System.out.println("当前线程：" + Thread.currentThread().getName() + "正在执行");
				Thread.sleep(1000);
				c.await();
				System.out.println("当前线程：" + Thread.currentThread().getName() + "执行完毕");
			} catch (Exception e) {

			}
		}
	}
}
