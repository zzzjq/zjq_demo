package zjq.test.leetcode;

/**
 * 蚂蚁金服面试题 0/1背包问题
 * 
 * @author zhangjq
 * @date 2019年4月12日下午7:17:42
 *
 **/
public class ZeroOrOnePackage {

	public static void main(String[] args) {
		// 物品的重量
		int[] weight = { 3, 4, 5 };
		// 对应的价值
		int[] value = { 4, 5, 7 };
		// 背包容量
		int m = 10;
		// 物品数量
		int n = 3;
		int[][] v = pick(m, n, weight, value);
		System.out.println(v[n][m]);
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				System.out.print(v[i][j] + "\t");
				if (j == m) {
					System.out.println();
				}
			}
		}
	}

	/**
	 * 动态规划
	 * 
	 * @param m
	 * @param n
	 * @param weight
	 * @param value
	 * @return
	 */
	public static int[][] pick(int m, int n, int[] weight, int[] value) {
		// 二维数组,表示前i件物品恰放入重量为m的背包可以获得的最大价值v
		int[][] v = new int[n + 1][m + 1];

		// 初始化第一行
		for (int i = 0; i < n + 1; i++) {
			v[i][0] = 0;
		}
		// 初始化第一列
		for (int i = 0; i < m + 1; i++) {
			v[0][i] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (weight[i - 1] <= j) {
					// 第i件物品可以放，但是放了价值不一定变高，要比较下价值大小，即V(i,j)=max｛V(i-1,j)，V(i-1,j-w(i))+v(i)｝
					v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i - 1]] + value[i - 1]);
				} else {
					// 第i件物品放不下,此时的价值与前i-1个的价值是一样的，即V(i,j)=V(i-1,j)；
					v[i][j] = v[i - 1][j];
				}
			}
		}
		return v;
	}

}
