package zjq.test.leetcode.easy;

/**
 * leetcode-136. 只出现一次的数字
 * 
 * 异或。a^0=a;a^a=0;
 * 
 * @author zhangjingqi
 * @date 2019年6月25日下午7:39:23
 *
 **/
public class SingleNumber {

	public int singleNumber(int[] nums) {
		int i = 0;
		for (int j : nums) {
			i ^= j;
		}
		return i;
	}

}
