package zjq.test.leetcode.easy;

/**
 * LeetCode-7 整数反转 简单
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 
 * @author zhangjq
 * @date 2019年4月14日下午1:50:26
 *
 **/
public class Reverse {

	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			result = result * 10 + pop;
		}

		return result;
	}
}
