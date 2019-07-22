package zjq.test.leetcode.easy.string;

/**
 * leetcode-28. 实现strStr() 暴力 || KMP
 * 
 * @author zhangjingqi
 * @date 2019年5月29日下午7:41:40
 *
 **/
public class StrStr {

	/**
	 * 暴力
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		char[] a = haystack.toCharArray();
		char[] b = needle.toCharArray();
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}

		return j == b.length ? i -j : -1;
	}
	
	/**
	 * KMP
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStrKMP(String haystack, String needle) {
		char[] a = haystack.toCharArray();
		char[] b = needle.toCharArray();
		int[] c = new int[needle.length()];
		getNext(needle, c);
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (j == -1 || a[i] == b[j]) {
				i++;
				j++;
			} else {
				//i = i - j + 1;
				j = c[j];
			}
		}
		return j == b.length ? i -j : -1;
	}
	
	private void getNext(String s, int[] next) {
		next[0] = -1;
		int i = 0;
		int j = -1;
		while (i < s.length() - 1) {
			if (j == -1 || s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
	}

}
