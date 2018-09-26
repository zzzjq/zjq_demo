package zjq.test.thread;

public class InterruptTest extends Object implements Runnable {

	public void run (){
		try{
			System.out.println("start");
			Thread.sleep(2000);
			System.out.println("wakeup");
//			Thread.interrupted();
		}catch(InterruptedException e){
			System.out.println("interrupted");
			return;
		}
		System.out.println("leave");
	}
	
	public static void main(String[] args){
		InterruptTest a = new InterruptTest();
		Thread t = new Thread(a);
		t.start();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("interrupted other");
		t.interrupt();
		System.out.println("leaving");
	}
}
