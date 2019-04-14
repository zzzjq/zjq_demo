package zjq.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode-1 两数之和 简单
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数， 并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
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
		for (int i = 0; i < nums.length; i++) {
			int a = target - nums[i];
			if (map.containsKey(a)) {
				return new int[] { map.get(a), i };
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
