package zjq.test.thread;

import java.util.concurrent.Semaphore;

/**
 * 信号量，Semaphore可以控同时访问的线程个数，
 * 通过 acquire() 获取一个许可，如果没有就等待，
 * 而 release() 释放一个许可。
 * 
 * @author zhangjq
 * @date 2019年2月21日下午4:58:20
 *
 **/
public class SemaphoreTest {

	public static void main(String[] args) {
		int n = 8;
		Semaphore s = new Semaphore(3);
		for(int i=0; i<n; i++) {
			new Thread(new worker(s, i)).start();
		}
	}
	static class worker implements Runnable{
		
		private int num;
		
		private Semaphore s;
		
		worker(Semaphore s, int num){
			this.s = s;
			this.num = num;
		}

		@Override
		public void run() {
			try {
				s.acquire();
				System.out.println(this.num + "正在工作");
				Thread.sleep(1000L);
				System.out.println(this.num + "结束工作");
				s.release();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
