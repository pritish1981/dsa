/**
 * 
 */
package tct2;

/**
 * @author User
 *
 */
public class Merge2SortedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(1);
		ListNode tail = head;
		// iterate until we reach the end of one list
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
		}
		tail = tail.next;
		if (l1 != null) {
			tail.next = l1;
			l1 = l1.next;
		}
		if (l2 != null) {
			tail.next = l2;
			l2 = l2.next;
		}
		// tail is pointing to head
		return head.next;
	}

	public static void main(String[] args) {
		ListNode tail1 = new ListNode(4, null);
		ListNode node1 = new ListNode(3, tail1);
		ListNode head1 = new ListNode(1, node1);

		ListNode tail2 = new ListNode(4, null);
		ListNode node2 = new ListNode(2, tail2);
		ListNode head2 = new ListNode(1, node2);

		ListNode ans = mergeTwoList(head1, head2);

		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}

	}

}
