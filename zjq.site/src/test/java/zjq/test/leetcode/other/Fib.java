package zjq.test.leetcode.other;

/**
 * 斐波那契数列
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午6:25:12
 *
 **/
public class Fib {

	public static int fib(int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		return fib(num - 2) + fib(num - 1);
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			System.out.println(fib(i));
		}
	}

}
