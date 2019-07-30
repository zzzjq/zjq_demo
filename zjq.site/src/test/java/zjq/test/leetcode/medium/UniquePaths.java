package zjq.test.leetcode.medium;

/**
 * Leetcode 62. 不同路径
 * 
 * 设dp[i][j]是从(0, 0)走到(i, j)的不同路径数目，
 * (i, j)可能是从(i - 1, j)向下一步，也可能是从(i, j - 1)向右一步。 
 * 故有dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * 
 * @author zhangjingqi
 * @date 2019年7月30日下午2:37:52
 *
 **/
public class UniquePaths {

	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++)
			dp[0][i] = 1;
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

}
