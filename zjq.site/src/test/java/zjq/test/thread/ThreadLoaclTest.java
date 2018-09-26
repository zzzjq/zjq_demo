package zjq.test.thread;
/**
 * @author:zhangjq
 * @time:2017年11月24日 下午2:06:05
 * @version:v1.0
 */
public class ThreadLoaclTest {

	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>();
	private static int i = 5;
	
	public static int getInt(){
		Integer a = local.get();
		if(a == null){
			local.set(i);
		}
		return local.get();
	}
	
	public static void main(String[] args){
		Thread[] threads = new Thread[10];
		for(int i=0;i<threads.length;i++){
			final int t = i;
			threads[i] = new Thread(new Runnable() {		
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + ":" + getInt() + t);
				}
			});
			threads[i].start();
		}
		/*Thread thread1 = new Thread(new Runnable() {		
			@Override
			public void run() {
				int a = getInt();
				System.out.println("thread1 :" +a);
				a = a+10;
				System.out.println("thread1 :" +a);

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int b = getInt();
				System.out.println("thread2 :" +b);
				b = b+15;
				System.out.println("thread2 :" +b);
			}
		});
		thread1.start();
		thread2.start();*/
	}
}
