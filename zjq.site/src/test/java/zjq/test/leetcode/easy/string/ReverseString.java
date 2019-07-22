package zjq.test.leetcode.easy.string;

/**
 * Leetcode 344. 反转字符串
 * 
 * @author zhangjingqi
 * @date 2019年7月22日下午7:54:27
 *
 **/
public class ReverseString {
	public void reverseString(char[] s) {
		int i = s.length - 1;
		for(int j = 0; j < s.length/2; j++) {
			char temp = s[j];
			s[j] = s[i];
			s[i] = temp;
			i--;
		}
	}
}
