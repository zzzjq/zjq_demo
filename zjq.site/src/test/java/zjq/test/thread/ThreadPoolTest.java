package zjq.test.thread;

/***
 *
 * 线程池例子（FixedThreadPool、CachedThreadPool、SingleThreadExecutor）
 * 
 * 	    在FixedThreadPool中，有一个固定大小的池，
 * 如果当前需要执行的任务超过了池大小，那么多于的任务等待状态，
 * 直到有空闲下来的线程执行任务，而当执行的任务小于池大小，
 * 空闲的线程也不会去销毁。
 * 
 * 
 *   CachedThreadPool会创建一个缓存区，
 * 将初始化的线程缓存起来，如果线程有可用的，
 * 就使用之前创建好的线程，如果没有可用的，
 * 就新创建线程，终止并且从缓存中移除已有60秒未被使用的线程。
 * 
 * 
 *  4个任务是顺序执行的，SingleThreadExecutor得到的是一个单个的线程，
 *  这个线程会保证你的任务执行完成，如果当前线程意外终止，会创建一个新线程继续执行任务，
 *  这和我们直接创建线程不同，也和newFixedThreadPool(1)不同。
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {

		// 线程数尽量与CPU数一致
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("当前是第" + i + "循环");
				threadPool.execute(new Runnable() {
					public void run() {
						for (int i = 1; i <= 4; i++) {
							System.out.println("当前线程:"
									+ Thread.currentThread().getName() + "执行的是"
									+ i);
						}
					}
				});
			}
		} catch (Exception e) {
		} finally {
			threadPool.shutdown();
		}

		/*ExecutorService threadPool = Executors.newCachedThreadPool();

		for (int i = 1; i < 5; i++) {
			final int taskID = i;
			threadPool.execute(new Runnable() {
				public void run() {
					for (int i = 1; i < 5; i++) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("第" + taskID + "次任务的第" + i + "次执行");
					}
				}
			});
		}
		// 任务完毕，关闭线程池
		threadPool.shutdown();*/

		/*ExecutorService threadPool = Executors.newSingleThreadExecutor();
		try {
			for (int i = 1; i < 5; i++) {
				final int taskID = i;
				threadPool.execute(new Runnable() {
					public void run() {
						for (int i = 1; i < 5; i++) {
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("第" + taskID + "次任务的第" + i
									+ "次执行");
						}
					}
				});
			}
		} finally {
			// 任务完毕，关闭线程池
			threadPool.shutdown();
		}*/

	}

}
