package zjq.test.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工厂，ThreadPoolExecutor来创建线程池 1、AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作；
 * 
 * 2、CallerRunsPolicy策略：如果线程池的线程数量达到上限，该策略会把任务队列中的任务放在调用者线程当中运行；
 * 
 * 3、DiscardOledestPolicy策略：该策略会丢弃任务队列中最老的一个任务，也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务，并尝试再次提交；
 * 
 * 4、DiscardPolicy策略：该策略会默默丢弃无法处理的任务，不予任何处理。当然使用此策略，业务场景中需允许任务的丢失；
 * 
 * 以上内置的策略均实现了RejectedExecutionHandler接口，当然你也可以自己扩展RejectedExecutionHandler接口，定义自己的拒绝
 * 
 * @author zhangjq
 * @date 2018年11月6日上午11:42:10
 *
 **/

public class ThreadPoolBuilder {

	private ThreadPoolBuilder() {
	}

	private static class InnerPoolBuilder {
		private static ThreadPoolBuilder threadPoolBuilder = new ThreadPoolBuilder();
	}

	public static ThreadPoolBuilder build() {
		return InnerPoolBuilder.threadPoolBuilder;
	}

	public ExecutorService buildPool(int corePoolSize, int maximumPoolSize, Long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> blockingQueue) {
		// return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
		// unit, blockingQueue,
		// Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

		return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, blockingQueue,
				Executors.defaultThreadFactory(), new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.out.println("自定义拒绝策略");
					}
				});
	}

	/**
	 * 如果使用有界队列，当任务无法加入pool，会抛出java.util.concurrent.RejectedExecutionException
	 * rejectedExecution可以自定义解决这个异常 ；或者使用无界队列
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pool = ThreadPoolBuilder.build().buildPool(2, 4, 1000L, TimeUnit.MILLISECONDS,
				new SynchronousQueue());
		try {
			for (int i = 0; i <= 10; i++) {
				pool.execute(new Runnable() {

					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName());
					}
				});
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("shutdown the pool");
			pool.shutdown();
			System.out.println("shutdown the pool success");
		}

		ExecutorService pool2 = ThreadPoolBuilder.build().buildPool(0, 4, 1000L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>());
		try {
			for (int i = 0; i <= 10; i++) {
				pool2.execute(new Runnable() {

					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName());
					}
				});
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("shutdown the pool2");
			pool2.shutdown();
			System.out.println("shutdown the pool2 success");
		}
	}

}
