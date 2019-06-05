package zjq.test.leetcode.easy;

/**
 * leetcode-88 合并两个有序数组
 * 
 * @author zhangjingqi
 * @date 2019年6月5日下午7:45:40
 *
 **/
public class Merge {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-- + --n;
		while (n >= 0) {
			nums1[i--] = (m >= 0 && nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = new int[] { 2, 5, 6 };
		int n = 3;
		merge(nums1, m, nums2, n);
	}

}
