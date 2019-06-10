package zjq.test.leetcode.easy;

/**
 * leetcode 509. 斐波那契数
 * 
 * @author zhangjingqi
 * @date 2019年6月10日下午7:59:48
 *
 **/
public class Fib {
	// 替换法
	public int fib(int N) {
		if (N == 0 || N == 1)
			return N;
		int i = 0;
		int j = 1;
		for (int k = 2; k <= N; k++) {
			int t = i + j;
			i = j;
			j = t;
		}
		return j;
	}

	//递归，N大 容易超时
	public int fib2(int N) {
		if (N == 0 || N == 1)
			return N;
		return fib2(N - 1) + fib2(N - 2);
	}

}
