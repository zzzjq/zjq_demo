package zjq.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * future/call, future.get() 获取返回值。
 * 
 * @author:zhangjq
 * @time:2017年1月11日 上午11:33:42
 * @version:v1.0
 */
public class CallbTest {

	public static void main(String[] args) throws Exception {
		/** 线程池方式 **/
		ExecutorService service = Executors.newFixedThreadPool(2);
		try {
			Future<String> future = service.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					System.out.println(Thread.currentThread().getName());
					return "future";
				}
			});
			System.out.println(future.get());
		} finally {
			service.shutdown();
		}

		/** FutureTask方式 **/
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName());
				return "futureTask";
			}
		});
		Thread t = new Thread(task);
		t.start();
		System.out.println(task.get());
	}

}
