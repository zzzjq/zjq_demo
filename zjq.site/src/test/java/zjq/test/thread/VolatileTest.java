package zjq.test.thread;
/**
 * @author:zhangjq
 * @time:2017年4月24日 下午5:53:19
 * @version:v1.0
 */
public class VolatileTest {

	//光volatile不能保持,只能保证每次读取的都是最新值
	public static volatile int race = 0;
	
	//加synchronized 线程就安全了
	public synchronized static void increase(){
		race++;
	}
	
	public static void main(String[] args){
		Thread[] threads = new Thread[20];
		for(int i = 0; i < 20; i++){
			threads[i] = new Thread(new Runnable() {				
				@Override
				public void run() {
					for(int i = 0; i < 1000; i++){
						//System.out.println是线程安全的
						//System.out.println(Thread.currentThread().getName() + "race：" + race);
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		while(Thread.activeCount() > 1)
			Thread.yield();
		
		System.out.print(race);
	}
}
