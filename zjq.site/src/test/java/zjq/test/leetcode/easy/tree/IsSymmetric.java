package zjq.test.leetcode.easy.tree;

import zjq.test.leetcode.TreeNode;

/**
 * leetcode-101. 对称二叉树
 * 
 * @author zhangjingqi
 * @date 2019年6月25日下午6:19:17
 *
 **/
public class IsSymmetric {

	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode l, TreeNode r) {
		if (l == null && r == null)
			return true;
		if (l == null || r == null)
			return false;
		return (l.val == r.val) && isMirror(l.left, r.right) && isMirror(l.right, r.left);
	}

}
