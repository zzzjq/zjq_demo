package zjq.test.leetcode.hard;

/**
 * leetcode-10 正则表达式匹配 动态规划
 * 
 * @author zhangjingqi
 * @date 2019年5月21日下午7:24:19
 *
 **/
public class IsMatch {

	public static boolean isMatch(String s, String p) {
		if (null == s || null == p)
			return false;
		
		int slen = s.length();
		int plen = p.length();
		boolean[][] m = new boolean[slen + 1][plen + 1];

		if (slen == 0 && plen > 0) {
			
		}
		
		for (int i = 0; i <= slen; i++) {
			for (int j = 0; j <= plen; j++) {
				if (i == 0 && j == 0) {
					m[i][j] = true;
					continue;
				}
				if (j == 0) {
					m[i][j] = false;
					continue;
				}
				if (p.charAt(j - 1) == '*') {
					if (j > 1) {
						m[i][j] = m[i][j - 2] || i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
								&& m[i - 1][j];
					}
				} else {

					m[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
							&& m[i - 1][j - 1];
				}
			}
		}
		return m[slen][plen];
	}

	public static void main(String[] args) {
//		System.out.println(isMatch("aa", "a"));
//		System.out.println(isMatch("aa", ".a"));
//		System.out.println(isMatch("aa", "*a"));
//		System.out.println(isMatch("aa", "a*"));
//		System.out.println(isMatch("aa", "a."));
		System.out.println(isMatch("", "."));
	}

}
