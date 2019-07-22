package zjq.test.leetcode.easy.fib;

/**
 * leetcode 70. 爬楼梯
 * 
 * @author zhangjingqi
 * @date 2019年6月10日下午7:50:15
 *
 **/
public class ClimbStairs {
	//超时
	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
	
	public int climbStairs2(int n) {
		if (n == 1)
			return 1;
		int i = 1;
		int j = 2;
		for(int k = 3; k <= n; k++) {
			int t = i + j;
			i = j;
			j = t;
		}
		return j;
	}
}
