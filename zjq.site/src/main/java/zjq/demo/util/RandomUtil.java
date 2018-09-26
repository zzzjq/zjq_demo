package zjq.demo.util;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangjq
 * @date 2018年5月2日 上午10:00:35
 *
 **/
public class RandomUtil {

	public static Random random = new Random();

	public static String getRandom(int length) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < length; i++) {
			boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
			if (isChar) { // 字符串
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				ret.append((char) (choice + random.nextInt(26)));
			} else { // 数字
				ret.append(Integer.toString(random.nextInt(10)));
			}
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(5);
		try {
			for (int i = 0; i < 100; i++) {
				e.submit(() -> {
					System.out.println("当前线程" + Thread.currentThread().getName() + "--" + getRandom(16));
				});
			}
		} finally {
			e.shutdown();
		}
	}

}
