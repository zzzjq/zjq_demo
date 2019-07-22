package zjq.test.leetcode.easy.array;

/**
 * Leetcode 169. 求众数
 * 
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * @author zhangjingqi
 * @date 2019年7月22日下午8:40:17
 *
 **/
public class MajorityElement {
	
	//投票法
	public static int majorityElement(int[] nums) {
		int count = 0;
		Integer curr = null;
		for (int i : nums) {
			if (count == 0) {
				curr = i;
			}
			count += (curr == i) ? 1 : -1;
		}
		return curr;
	}
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {1,2,3,3,3}));
	}

}
