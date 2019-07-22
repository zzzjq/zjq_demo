package zjq.test.leetcode.easy.number;

/**
 * leetcode-35. 搜索插入位置
 * 
 * 还有个二分
 * 
 * @author zhangjingqi
 * @date 2019年5月31日下午6:06:07
 *
 **/
public class SearchInsert {

	public static int searchInsert(int[] nums, int target) {
		if (target == 0)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
	}

}
