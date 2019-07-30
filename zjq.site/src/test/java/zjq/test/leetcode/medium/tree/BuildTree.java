package zjq.test.leetcode.medium.tree;

import zjq.test.leetcode.TreeNode;

/**
 * Leetcode 105. 从前序与中序遍历序列构造二叉树
 * 
 * @author zhangjingqi
 * @date 2019年7月30日下午3:53:10
 *
 **/
public class BuildTree {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int[] inorder, int i, int j) {
		if(i > j) return null;
		TreeNode root = new TreeNode(preorder[0]);
		int k = 0;
		while (inorder[k] != root.val)
			k++;
		root.left = build(preorder, inorder, i + 1, k);
		root.right = build(preorder, inorder, i + 1 + k - j, j - k);
		return root;
	}
}
