package zjq.test.leetcode.other;

import java.util.HashSet;

/**
 * 蚂蚁金服面试题 打印int数组中第11大的数，和除前十个大数以外的所有数字的中位数，数组可能有重复的值。个数少于100个。（java）
 * 
 * 可以在命令行执行，数组在命令行输入，或者在代码里都行。
 * 
 * 如：1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 11 11 12 12 11 12 7 8
 * 
 * 第一大的数字是12， 第二大的是11，第三大的是10， 以此类推 第k大的数字
 * 
 * @author zhangjq
 * @date 2019年4月12日下午8:33:40
 *
 **/
public class ZjqTest {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3, 5, 5, 4, 6, 8, 7, 7, 8, 6, 9, 9, 9, 2, 3 };
		int k = 3;
		int num = findKthLargest(a, k);
		System.out.printf("第%d大的数字是%d", k, num);
	}

	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		// 去重
		HashSet<Integer> set = new HashSet<Integer>(nums.length);
		for (int i : nums) {
			set.add(i);
		}
		return sort(set.toArray(new Integer[] {}), 0, set.size() - 1, k);
	}

	// 利用快排找到第k大的数字
	public static int sort(Integer[] a, int start, int end, int k) {
		int mid = getMiddle(a, start, end);
		// 判断取到的当前基准位置是否为第k大
		if (mid == k - 1) {
			return a[mid];
		} else if (mid < k - 1) {
			return sort(a, mid + 1, end, k);
		} else {
			return sort(a, start, mid - 1, k);
		}
	}

	public static int getMiddle(Integer[] a, int start, int end) {
		// 取当前数组第一个为基准
		int temp = a[start];

		while (start < end) {
			// 从后往前遍历，找比基准大的交换位置
			while (start < end && a[end] <= temp) {
				end--;
			}
			a[start] = a[end];
			// 从前往后遍历，找比基准小的交换位置
			while (start < end && a[start] >= temp) {
				start++;
			}
			a[end] = a[start];
		}
		a[end] = temp;
		return end;
	}
}
