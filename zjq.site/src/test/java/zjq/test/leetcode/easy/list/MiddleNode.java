package zjq.test.leetcode.easy.list;

/**
 * Leetcode 876. 链表的中间结点
 * 
 * 快慢指针, 慢指针每次走一个，快指针每次走2个；
 * 快指针的终止条件是本身为null或者next为空，保证偶数个数的时候，取后面的节点；
 * 
 * @author zhangjingqi
 * @date 2019年7月18日下午7:44:10
 *
 **/
public class MiddleNode {

	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
}
