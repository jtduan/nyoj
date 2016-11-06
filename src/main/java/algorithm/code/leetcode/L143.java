package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/3
 */
public class L143 {
    public void reorderList(ListNode head) {
        int len = getLen(head);
        if (len <= 2) return;
        int half = (len + 1) / 2;
        ListNode cur1 = head;
        while (--half > 0) {
            cur1 = cur1.next;
        }
        ListNode head2 = reverse(cur1.next);
        cur1.next = null;

        ListNode cur2 = head2;
        cur1 = head;
        while (cur2 != null) {
            ListNode temp1 = cur1.next;
            ListNode temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;
            cur2 = temp2;
            cur1 = temp1;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode newhead = new ListNode(0);
        newhead.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newhead.next;
            newhead.next = head;
            head = temp;

        }
        return newhead.next;
    }

    private int getLen(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        new L143().reorderList(node1);

        while(node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
}
