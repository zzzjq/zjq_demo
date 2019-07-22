package zjq.test.leetcode.easy;

/**
 * 292. Nim 游戏
 * 
 * @author zhangjingqi
 * @date 2019年7月22日下午8:13:31
 *
 **/
public class CanWinNim {
	public boolean canWinNim(int n) {
		return !(n % 4 == 0);
	}
}
