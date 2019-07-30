package zjq.test.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

import zjq.test.leetcode.TreeNode;

/**
 * Leetcode 257. 二叉树的所有路径
 * 
 * @author zhangjingqi
 * @date 2019年7月30日下午4:10:50
 *
 **/
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		binaryTreePaths(root, list);
		return list;
	}

	private void binaryTreePaths(TreeNode root, List<String> list) {
		
	}

}
