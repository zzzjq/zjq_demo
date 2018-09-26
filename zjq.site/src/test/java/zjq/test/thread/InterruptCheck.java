package zjq.test.thread;

public class InterruptCheck extends Object{

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();
		System.out.println("a.."+t.isInterrupted());
		t.interrupt();
		System.out.println("b.."+t.isInterrupted());
		System.out.println("c.."+t.isInterrupted());
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			System.out.println("d.."+t.isInterrupted());
		}
	}

}
