package algorithm.code.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if(l!=null)queue.add(l);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) queue.add(node.next);
        }
        return head.next;
    }
}
