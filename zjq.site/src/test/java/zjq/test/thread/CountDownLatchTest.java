package zjq.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了
 * 
 * @author zhangjq
 * @date 2019年2月21日下午5:09:46
 *
 **/
public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch c = new CountDownLatch(2);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("线程1正在执行");
					Thread.sleep(3000L);
					c.countDown();
					System.out.println("线程1执行完毕");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("线程2正在执行");
					Thread.sleep(8000L);
					c.countDown();
					System.out.println("线程2执行完毕");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		try {
			System.out.println("等待线程执行完毕");
			t1.start();
			t2.start();
			c.await();
			System.out.println("线程执行完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
