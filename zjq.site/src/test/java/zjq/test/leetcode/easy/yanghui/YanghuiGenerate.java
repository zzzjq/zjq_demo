package zjq.test.leetcode.easy.yanghui;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode-118. 杨辉三角 
 * 
 * 动态规划 a[i][j] = a[i-1][j-1] + a[i-1][j]
 * 
 * @author zhangjingqi
 * @date 2019年7月1日下午7:27:57
 *
 **/
public class YanghuiGenerate {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows < 1)
			return result;

		for (int i = 0; i < numRows; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					temp.add(1);
				} else {
					temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			result.add(temp);
		}
		return result;
	}
}
