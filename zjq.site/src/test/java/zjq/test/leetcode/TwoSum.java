package zjq.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhangjq
 * @date 2019年3月26日下午6:37:19
 *
 **/
public class TwoSum {

	// 时间复杂度O(n^2);空间复杂度O(1);
	public static int[] twoSum(int[] nums, int target) {
		int[] a = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					a[0] = i;
					a[1] = j;
					break;
				}
			}
		}
		return a;
	}

	// 时间复杂度O(n);空间复杂度O(n);
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int a = target - nums[i];
			if(map.containsKey(a)) {
				return new int[] {map.get(a), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = twoSum2(new int[] { 2, 7, 11, 15 }, 13);
		System.out.println(a[0]);
		System.out.println(a[1]);
	}
}
