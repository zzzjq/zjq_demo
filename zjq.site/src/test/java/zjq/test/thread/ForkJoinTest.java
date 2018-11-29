package zjq.test.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * fork/join
 * 
 * @author zhangjq
 * @date 2018年11月28日下午3:33:11
 *
 **/
public class ForkJoinTest extends RecursiveTask<Integer> {

	private int start;

	private int end;

	public ForkJoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if (end - start <= 2) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int mid = (end + start) / 2;
			ForkJoinTest left = new ForkJoinTest(start, mid);
			left.fork();
			ForkJoinTest right = new ForkJoinTest(mid + 1, end);
			right.fork();
			sum = right.join() + left.join();
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		ForkJoinTest test = new ForkJoinTest(1, 10);
		ForkJoinPool pool = new ForkJoinPool();
		Future<Integer> result = pool.submit(test);
		System.out.println(result.get());
	}

}
