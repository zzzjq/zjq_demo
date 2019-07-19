package zjq.test.leetcode.easy.list;

/**
 * Leetcode 203. 移除链表元素
 * 
 * @author zhangjingqi
 * @date 2019年7月19日下午2:38:38
 *
 **/
public class RemoveElements {

	// 递归
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		if (head.val == val)
			return head.next;
		return head;
	}

	//设置个虚拟节点
	public ListNode removeElements2(ListNode head, int val) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode pre = temp;
		while (pre.next != null) {
			if (pre.next.val == val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}
		return temp.next;
	}

}
