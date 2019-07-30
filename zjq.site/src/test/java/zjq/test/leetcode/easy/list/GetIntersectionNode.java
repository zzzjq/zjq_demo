package zjq.test.leetcode.easy.list;

import zjq.test.leetcode.ListNode;

/**
 * leetcode 160. 相交链表
 * 
 * 双指针
 * 
 * @author zhangjingqi
 * @date 2019年6月24日下午7:52:20
 *
 **/
public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

}
