package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/2
 */
public class L86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode left_tail = left;
        ListNode right = new ListNode(0);
        ListNode right_tail = right;
        while (head != null) {
            if (head.val < x) {
                left_tail.next = head;
                left_tail = head;
            } else {
                right_tail.next = head;
                left_tail = head;
            }
            head = head.next;
        }
        right_tail.next = null;
        left_tail.next = right.next;
        return left.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}