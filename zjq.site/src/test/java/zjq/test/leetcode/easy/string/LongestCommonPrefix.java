package zjq.test.leetcode.easy.string;

/**
 * leetcode-14 最长公共前缀
 * 
 * @author zhangjq
 * @date 2019年5月20日下午4:41:25
 *
 **/
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) 
			return "";
		if(strs.length == 1)
			return strs[0];
		
		int len = strs[0].length();
		for(int i = 0; i< len ; i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"aaaccc","aacc","aabb"}));
	}
	
}
