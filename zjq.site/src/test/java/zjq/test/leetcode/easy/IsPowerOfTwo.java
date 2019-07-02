package zjq.test.leetcode.easy;

/**
 * leetcode 231. 2的幂
 * 
 * 2的幂 二进制满足 (n & (n - 1)) == 0; 注意，&优先级大于==
 * 
 * @author zhangjingqi
 * @date 2019年7月2日下午8:56:45
 *
 **/
public class IsPowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		return n == 1 ? true : (n & (n - 1)) == 0;
	}
}
