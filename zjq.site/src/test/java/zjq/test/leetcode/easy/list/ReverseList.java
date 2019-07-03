package zjq.test.leetcode.easy.list;

/**
 * 
 * @author zhangjingqi
 * @date 2019年7月3日下午8:42:32
 *
 **/
public class ReverseList {

	//递归
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode result = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}
	
	public ListNode reverseList2(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}

}
