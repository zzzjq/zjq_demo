package zjq.test.leetcode.medium.list;

import zjq.test.leetcode.ListNode;

/**
 * Leetcode 61. 旋转链表
 * 
 * 链表头尾相连，找断裂点，形成新的链表
 * 
 * @author zhangjingqi
 * @date 2019年7月30日下午2:20:40
 *
 **/
public class RotateRight {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode old = head;
		int n = 1;
		for (; old.next != null; n++) {
			old = old.next;
		}
		old.next = head;
		// k%n 肯定小于n；找到断裂的节点
		ListNode new_ = head;
		for (int i = 0; i < n - k % n - 1; i++) {
			new_ = new_.next;
		}
		ListNode result = new_.next;
		new_.next = null;
		return result;
	}

}
