package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode newhead = null;
		ListNode cur = head;
		if (getLen(head) < k) {
			return head;
		}
		for (int i = 0; i < k; i++) {
			ListNode next = cur.next;
			cur.next = newhead;
			newhead = cur;
			cur = next;
		}
		head.next = reverseKGroup(cur, k);
		return newhead;
	}

	private int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
