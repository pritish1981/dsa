/**
 * 
 */
package linkedlist2;

/**
 * @author Pritish
 *
 */
public class FindMiddleElementOfLinkedList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public int solve(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
