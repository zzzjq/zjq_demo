package zjq.test.leetcode.easy.tree;

/**
 * leetcode-104. 二叉树的最大深度
 * 
 * @author zhangjingqi
 * @date 2019年6月24日下午8:31:03
 *
 **/
public class MaxDepth {

	public int maxDepth(TreeNode root) {
		return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
