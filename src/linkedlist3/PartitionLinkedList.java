/**
 * 
 */
package linkedlist3;

/**
 * Partitioning a linked list around a given value and keeping the original order
 *Solution Approach:
 *1->4->3->2->5->2 , x=3
 make two dummy variable and initialize them with 0(to avoid handle null things)
left :0
right:0

iterate over given node. If node value is less than x add it to left else add to right.

left : 0 -> 1 -> 2 -> 2
right : 0 -> 4 -> 3 -> 5

now connect tail of left to 4(i.e right.next)

left : 0->1->2->2->4->3->5
make tail2.next=null;
return left.next;
 */
public class PartitionLinkedList {

	static class ListNode {
		int val;
		ListNode next;
	}

	static ListNode partition(ListNode A, int B) {
		if (A == null)
			return null;

		ListNode left = new ListNode();
		ListNode right = new ListNode();

		ListNode tail1 = left, tail2 = right;

		while (A != null) {
			if (A.val < B) {
				tail1.next = A;
				tail1 = tail1.next;
			} else {
				tail2.next = A;
				tail2 = tail2.next;
			}
			A = A.next;
		}
		tail1.next = right.next;
		tail2.next = null; // important

		return left.next;
	}

	// A utility function to create a new node
	static ListNode newNode(int data) {
		ListNode new_node = new ListNode();
		new_node.val = data;
		new_node.next = null;
		return new_node;
	}

	/* Function to print linked list */
	static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		ListNode head = newNode(10);
		head.next = newNode(4);
		head.next.next = newNode(5);
		head.next.next.next = newNode(30);
		head.next.next.next.next = newNode(2);
		head.next.next.next.next.next = newNode(50);

		int x = 3;
		head = partition(head, x);
		printList(head);

	}

}
