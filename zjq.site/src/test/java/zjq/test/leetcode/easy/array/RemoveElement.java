package zjq.test.leetcode.easy.array;

/**
 * leetcode-27 移除元素
 * 双指针-快慢指针
 * 和26题相似
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午7:48:18
 *
 **/
public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		if(0 == nums.length)
			return 0;
		int i = 0;
		for(int j=0; j<nums.length; j++) {
			if(nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {3,2,2,3};
		System.out.println(removeElement(a, 3));
	}
	
}
