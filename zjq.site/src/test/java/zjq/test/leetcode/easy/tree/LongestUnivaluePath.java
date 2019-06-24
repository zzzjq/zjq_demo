package zjq.test.leetcode.easy.tree;

import zjq.test.leetcode.TreeNode;

/**
 * leetcode-687 最长同值路径
 * 递归
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午7:27:26
 *
 **/
public class LongestUnivaluePath {

	int re;

	public int longestUnivaluePath(TreeNode root) {
		re = 0;
		longestUnivaluePath2(root);
		return re;
	}

	public int longestUnivaluePath2(TreeNode root) {
		if (null == root)
			return 0;
		int left = longestUnivaluePath2(root.left);
		int right = longestUnivaluePath2(root.right);
		int l = 0;
		int r = 0;
		if (root.left != null && root.left.val == root.val) {
			l = left + 1;
		}
		if (root.right != null && root.right.val == root.val) {
			r = right + 1;
		}
		re = Math.max(re, l + r);
		return Math.max(l, r);
	}

}
