package zjq.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了
 * 
 * @author zhangjq
 * @date 2019年2月21日下午5:09:46
 *
 **/
public class CountDownLatchTest implements Runnable {

	private final CountDownLatch countDownLatch;

	public CountDownLatchTest(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("线程：" + Thread.currentThread().getName() + "正在执行");
		try {
			Thread.sleep(3000L);
			this.countDownLatch.countDown();
		} catch (Exception e) {
		}
		System.out.println("线程：" + Thread.currentThread().getName() + "执行完毕");
	}

	public static void main(String[] args) {
		CountDownLatch c = new CountDownLatch(2);
		Thread t1 = new Thread(new CountDownLatchTest(c));
		Thread t2 = new Thread(new CountDownLatchTest(c));
		try {
			System.out.println("主线程等待所有子线程执行完毕");
			t1.start();t2.start();
			c.await();
			System.out.println("主线程执行完毕");
		} catch (Exception e) {
		}
	}

}
