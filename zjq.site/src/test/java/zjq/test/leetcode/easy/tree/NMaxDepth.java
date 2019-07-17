package zjq.test.leetcode.easy.tree;

/**
 * Leetcode 559. N叉树的最大深度
 * 
 * @author zhangjingqi
 * @date 2019年7月17日下午8:27:28
 *
 **/
public class NMaxDepth {

	public int maxDepth(Node root) {
		if(root == null) return 0;
		int dep = 0;
		for(Node node : root.children) {
			int max = maxDepth(node);
			dep = Math.max(dep, max);
		}
		return dep + 1;
	}
	
}
