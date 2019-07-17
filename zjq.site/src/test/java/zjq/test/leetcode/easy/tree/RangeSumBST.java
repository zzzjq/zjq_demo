package zjq.test.leetcode.easy.tree;

/**
 * Leetcode 938. 二叉搜索树的范围和
 * 
 * @author zhangjingqi
 * @date 2019年7月17日下午8:41:03
 *
 **/
public class RangeSumBST {

	public int rangeSumBST(TreeNode root, int L, int R) {
		if(root == null)
			return 0;
		if(root.val < L)
			return rangeSumBST(root.right, L, R);
		if(root.val > R)
			return rangeSumBST(root.left, L, R);
		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}
}
