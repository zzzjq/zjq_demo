package zjq.test.thread;

/**
 * interrupt只是给线程设置一个中断标志位置，对正在运行的线程没有任何影响。
 * 只有当线程在sleep、wait、join的时候，
 * 如果被interrupt，就会抛出InterruptedException，表示被中断当前的状态，
 * 线程可以catch后，做操作或者直接结束线程。
 * 这个东西类似于一个信号量，告知该线程，线程可以通过catch InterruptedException 或者
 * 判断isInterrupted，来做下一步操作。
 * 
 * @author idealife
 *
 */
public class InterruptTest implements Runnable {

	@Override
	public void run (){
		try{
			System.out.println("线程开始");
			System.out.println("当前线程是否中断状态:" + Thread.currentThread().isInterrupted());
			Thread.sleep(5000);
			System.out.println("线程结束sleep");
		}catch(InterruptedException e){
			System.out.println("当前线程是否中断状态:" + Thread.currentThread().isInterrupted());
			return;
		}
		System.out.println("当前线程是否中断状态:" + Thread.currentThread().isInterrupted());
		System.out.println("线程死亡");
	}
	
	public static void main(String[] args){
		Thread t = new Thread(new InterruptTest());
		t.start();
		System.out.println("中断线程t");
		t.interrupt();
	}
}
