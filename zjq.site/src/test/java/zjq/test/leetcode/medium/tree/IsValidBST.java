package zjq.test.leetcode.medium.tree;

import zjq.test.leetcode.TreeNode;

/**
 * Leetcode 98. 验证二叉搜索树
 * 
 * @author zhangjingqi
 * @date 2019年7月30日下午3:04:14
 *
 **/
public class IsValidBST {
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	private boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null)
			return true;
		if (left != null && root.val <= left.val)
			return false;
		if (right != null && root.val >= right.val)
			return false;
		return isValidBST(root.left, left, root) && isValidBST(root.right, root, right);
	}
	
	double last = -Double.MAX_VALUE;
	//中序遍历是升序
	public boolean isValidBST2(TreeNode root) {
		if(root == null)
			return true;
		if(isValidBST2(root.left)) {
			if(last < root.val) {
				last = root.val;
				return isValidBST2(root.right);
			}
		}
		return false;
	}
}
