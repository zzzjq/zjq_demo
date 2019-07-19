package zjq.test.leetcode.easy.list;

/**
 * Leetcode 141. 环形链表
 * 
 * 快慢指针
 * 
 * @author zhangjingqi
 * @date 2019年7月19日下午2:26:30
 *
 **/
public class HasCycle {

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			if(fast == slow)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

}