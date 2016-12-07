package awesome;

/**
 * Created by djt on 10/22/16.
 */
public class L148 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null) return head;

		ListNode left=new ListNode(0);
		left.next=null;

		ListNode right=new ListNode(0);
		right.next=null;

		ListNode p = head.next;
		while(p!=null){
			ListNode temp = p.next;
			if(p.val>=head.val){
				ListNode temp2 = right.next;
				right.next=p;
				p.next=temp2;
			}
			else{
				ListNode temp2=left.next;
				left.next=p;
				p.next=temp2;
			}
			p = temp;
		}
		ListNode new_head = sortList(left.next);

		if(new_head!=null) {
			ListNode temp = new_head;
			while (temp.next != null) temp = temp.next;

			temp.next = head;
			head.next = sortList(right.next);

			return new_head;
		}else{
			head.next = sortList(right.next);
			return head;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new L148().new ListNode(3);
		ListNode node2 = new L148().new ListNode(4);
		ListNode node3 = new L148().new ListNode(13);
		ListNode node4 = new L148().new ListNode(7);
		ListNode node5 = new L148().new ListNode(1);
		ListNode node6 = new L148().new ListNode(9);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		ListNode head = new L148().sortList(node1);
		while(head!=null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
