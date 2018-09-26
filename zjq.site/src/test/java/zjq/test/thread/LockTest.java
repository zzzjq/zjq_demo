package zjq.test.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Lock lock = new ReentrantLock();

	// lock如果为局部变量 则每个线程在启动时 会新建一个lock 不是同一个锁；所以必须为全局锁
	public static void main(String[] args) {
		final LockTest test = new LockTest();
		
		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			}
		}.start();

		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			}
		}.start();

	}

	public void insert(Thread thread) {
//		lock.lock();
		if(lock.tryLock()){
		try {
			System.out.println(thread.getName() + " locked");
			for (int i = 1; i < 5; i++) {
				list.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(thread.getName() + " unlocked");
			lock.unlock();
		}
	}else{
		System.out.println(thread.getName()+" lockfailed");
	}
	}
}
