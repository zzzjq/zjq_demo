package zjq.test.leetcode.easy;

/**
 * LeetCode-9 回文数 简单 
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * @author zhangjq
 * @date 2019年4月14日下午2:00:18
 *
 **/
public class IsPalindrome {

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x >= 0 && x < 10) {
			return true;
		}	
		int temp = x;
		int result = 0;
		while (x > 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		return temp == result;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
	}
}
