package zjq.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author:zhangjq
 * @time:2017年1月11日 上午11:33:42
 * @version:v1.0
 */
public class CallbTest{

	private static final ExecutorService service = Executors
			.newFixedThreadPool(2);
		
	public static void main(String[] args){
		try{
		Future<String> future = service.submit(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName());
				return "call1";
			}
			
		});
		}finally{
			service.shutdown();
		}
		
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName());
				return "call2";
			}
		});
		Thread t = new Thread(task);
		t.start();
	}
}
