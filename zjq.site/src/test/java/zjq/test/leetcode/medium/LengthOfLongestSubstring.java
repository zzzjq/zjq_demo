package zjq.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-3 无重复最长子串
 * 滑动窗口算法
 * 
 * @author zhangjq
 * @date 2019年5月20日下午3:29:48
 *
 **/
public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			map.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		String s = "acbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
