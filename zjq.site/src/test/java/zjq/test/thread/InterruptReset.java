package zjq.test.thread;


public class InterruptReset extends Object {

	public static void main(String[] args) {
		System.out.println("a.."+Thread.interrupted());
		Thread.currentThread().interrupt();
		System.out.println("b.."+Thread.interrupted());
		System.out.println("c.."+Thread.interrupted());
	}

}
