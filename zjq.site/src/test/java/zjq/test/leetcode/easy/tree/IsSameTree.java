package zjq.test.leetcode.easy.tree;

import zjq.test.leetcode.TreeNode;

/**
 * leetcode-100. 相同的树
 * 
 * @author zhangjingqi
 * @date 2019年6月24日下午8:52:22
 *
 **/
public class IsSameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null && p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}

}
