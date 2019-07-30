package zjq.test.leetcode;

import java.util.List;

/**
 * N叉树节点
 * 
 * @author zhangjingqi
 * @date 2019年7月17日下午8:25:30
 *
 **/

public class Node {

	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int val, List<Node> children) {
		this.val = val;
		this.children = children;
	}

}
