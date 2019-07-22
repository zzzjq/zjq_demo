package zjq.test.leetcode.easy.array;

/**
 * leetcode-26 删除排序数组中的重复项
 * 双指针-快慢指针
 * 和27题相似
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午7:10:53
 *
 **/
public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		if (0 == nums.length)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if(nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j]; 
			}
		}
		return i + 1;
	}
	
	public static void main(String[] agrs) {
		int[] i = new int[] {1,1,2,3,3,4};
		System.out.println(removeDuplicates(i));
	}
	
}
