package zjq.test.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

import zjq.test.leetcode.TreeNode;

/**
 * Leetcode 94. 二叉树的中序遍历
 * 
 * @author zhangjingqi
 * @date 2019年7月30日下午3:29:49
 *
 **/
public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		inorderTraversal(root, result);
		return result;
	}

	private void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (root.left != null) {
			inorderTraversal(root.left, list);
		}
		list.add(root.val);
		if (root.right != null) {
			inorderTraversal(root.right, list);
		}
	}

}
