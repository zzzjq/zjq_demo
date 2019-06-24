package zjq.test.leetcode.easy;

/**
 * leetcode-167. 两数之和 II - 输入有序数组
 * 
 * @author zhangjingqi
 * @date 2019年6月24日下午7:38:43
 *
 **/
public class TwoSum2 {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				result[0] = i + 1;
				result[1] = j + 1;
				break;
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return result;
	}

}
