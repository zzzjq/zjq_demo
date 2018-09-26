package zjq.test.thread;
/**
 * @author:zhangjq
 * @time:2017年4月25日 上午10:06:01
 * @version:v1.0
 */
public class ThreadJoinTest {

	public static void main(String[] args){
		
		final Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					
					System.out.print("123");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread1.start();
		
		final Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					//等待线程1执行完毕
					thread1.join();
					System.out.print("456");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread2.start();
		
	}
}
