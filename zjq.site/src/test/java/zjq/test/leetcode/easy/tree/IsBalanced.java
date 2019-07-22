package zjq.test.leetcode.easy.tree;

/**
 * Leetcode 110. 平衡二叉树
 * 
 * @author zhangjingqi
 * @date 2019年6月25日下午6:11:08
 *
 **/
public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
	}

	private int depth(TreeNode root) {
		return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
	}
}
