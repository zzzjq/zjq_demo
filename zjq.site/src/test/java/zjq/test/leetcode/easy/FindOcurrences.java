package zjq.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode-1078. Bigram 分词
 * 
 * @author zhangjingqi
 * @date 2019年6月26日下午7:43:57
 *
 **/
public class FindOcurrences {

	public String[] findOcurrences(String text, String first, String second) {
		if (text == null)
			return null;
		String[] s = text.split(" ");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length - 2; i++) {
			if (s[i].equals(first) && s[i + 1].equals(second)) {
				list.add(s[i + 2]);
			}
		}
		return list != null ? list.toArray(new String[] {}) : null;
	}
}
