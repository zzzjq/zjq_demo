package zjq.test.data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 生产者消费者，BlockQueue实现
 * 
 * @author:zhangjq
 * @time:2018年2月28日 下午3:04:55
 * @version:v1.0
 */
public class BlockQueueTest {

	private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
	
	public static void produce() throws InterruptedException{
		queue.put("A");
	}
	
	public static String consume() throws InterruptedException{
		return queue.take();
	}
	
	public static int getSize(){
		return queue.size();
	}
	
	static class Producer implements Runnable{
		@Override
		public void run() {
			int i=0;
			while(true){
				try {
					produce();
					i++;
					System.out.println("生产开始" + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	
	static class Consumer implements Runnable{
		@Override
		public void run() {
			int i = 0;
			while(true){
				while(getSize() >0){
					/**控制下速度**/
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						consume();
						i++;
						System.out.println("消费开始" + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		try {
			Producer pro = new Producer();
			Consumer con = new Consumer();
			ex.submit(pro);
			ex.submit(con);
		} catch (Exception e) {
		} finally {
			ex.shutdown();
		}
	}
	
}
