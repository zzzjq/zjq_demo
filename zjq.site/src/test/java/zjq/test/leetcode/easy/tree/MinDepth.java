package zjq.test.leetcode.easy.tree;

/**
 * leetcode-111. 二叉树的最小深度
 * 
 * @author zhangjingqi
 * @date 2019年6月24日下午8:18:52
 *
 **/
public class MinDepth {

	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null)
			return minDepth(root.right) + 1;
		if(root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
