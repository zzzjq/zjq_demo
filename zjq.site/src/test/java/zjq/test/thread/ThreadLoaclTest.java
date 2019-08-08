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
			threads[i] = new Thread(new Runnable() {		
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + ":" + getInt());
				}
			});
			threads[i].start();
		}
	}

}
