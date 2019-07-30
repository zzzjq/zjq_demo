package zjq.test.leetcode.easy.list;

import zjq.test.leetcode.ListNode;

/**
 * Leetcode 237. 删除链表中的节点
 * 
 * @author zhangjingqi
 * @date 2019年7月19日下午3:49:23
 *
 **/
public class DeleteNode {

	public void deleteNode(ListNode node) {
		if(node == null) return;
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
