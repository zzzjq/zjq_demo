package zjq.test.leetcode.easy.list;

import zjq.test.leetcode.ListNode;

/**
 * Leetcode 206. 反转链表
 * 
 * @author zhangjingqi
 * @date 2019年7月3日下午8:42:32
 *
 **/
public class ReverseList {

	// 递归
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode result = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}

	public ListNode reverseList2(ListNode head) {
		ListNode re = null;
		ListNode curr = head;
		while (curr != null) {
			// 每次把curr的下一个节点先存起来，赋值回curr
			ListNode next = curr.next;
			// 把curr的下一个节点指向新建的链表节点，一开始是null，后面每次都是curr的前一个节点
			curr.next = re;
			// 把反转的子链赋值回re
			re = curr;
			// 把存好的下一个节点重新给curr，一直到没有下一个节点
			curr = next;
		}
		return re;
	}

}
