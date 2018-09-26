package zjq.test.thread;
/**
 * @author:zhangjq
 * @time:2018年3月7日 下午2:18:42
 * @version:v1.0
 */
public class mainThread {

	public static void main(String[] args){
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName());
//			}
//		});
//		Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName());
//			}
//		});
//		//新建线程，与当前的main线程不一样
//		t1.start();
//		//t1.start();只能运行一次
//		t2.run();
//		t2.run();//run只是在跑当前线程（main）而已
		
		
		//Thread嵌套
		System.out.println(Thread.currentThread().getName());
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}, "zjq");
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				Thread thread1 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName());
					}
				});
				thread1.start();
			}
		});
		thread1.start();
		thread2.start();
	}
}
