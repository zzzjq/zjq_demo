package zjq.test.thread;

/**
 * TimerTask 例子
 * 
 * */

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	static class MyTimerTask extends TimerTask {
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(2000);
					System.out.println("BOOM!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		try {
			MyTimerTask myTimerTask = new MyTimerTask();
			timer.schedule(myTimerTask, 2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			timer.cancel();
		}
	}
}
