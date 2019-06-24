package zjq.test.leetcode.easy.list;

import zjq.test.leetcode.ListNode;

/**
 * leetcode-83. 删除排序链表中的重复元素
 * 
 * @author zhangjingqi
 * @date 2019年6月10日下午7:24:49
 *
 **/
public class DeleteDuplicates {

	// 递归
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		if (head.val == head.next.val)
			head = head.next;
		return head;
	}
	//单指针
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode l = head;
		while (l != null && l.next != null) {
			if (l.val == l.next.val) {
				l.next = l.next.next;
			} else {
				l = l.next;
			}
		}
		return head;
	}

}


