package zjq.test.thread;

public class DeadLock {

	private static String objId;

	//构造函数(不写 jvm会有默认方法)
	public DeadLock(String id) {
		objId = id;
	}

	public synchronized void checkOther(DeadLock other) {
		print("entering checkOther()");
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			
		}
		print("in checkOther() - about to " + "invoke 'other.action()'");

		other.action();
		print("leaving checkOther()");
	}

	public synchronized void action() {
		print("entering action()");
		try {
			Thread.sleep(500);
		} 
		catch (InterruptedException x) {
			
		}
		print("leaving action()");
	}

	public void print(String msg) {
		threadPrint("objID=" + objId + " - " + msg);
	}

	public static void threadPrint(String msg) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + msg);
	}

	public static void main(String[] args) throws Exception{
		final DeadLock obj1 = new DeadLock("obj1");
		final DeadLock obj2 = new DeadLock("obj2");

		Runnable A = new Runnable() {
			public void run() {
				obj1.checkOther(obj2);
			}
		};

		Thread AA = new Thread(A, "AA");
		AA.start();

		Thread.sleep(500);//发生死锁
		//Thread.sleep(3000);//这个时间如果比checkOther的时间长，则不会发生死锁

		Runnable B = new Runnable() {
			public void run() {
				obj2.checkOther(obj1);
			}
		};

		Thread BB = new Thread(B, "BB");
		BB.start();
		Thread.sleep(3000);

		threadPrint("finsh sleeping");
		
		threadPrint("start to interrupt() AA");
		AA.interrupt();
		Thread.sleep(1000);

		threadPrint("start to interrupt() BB");
		BB.interrupt();
		Thread.sleep(1000);
		
		threadPrint("did that break the deadlock?");
	}

}
