/**
 * 
 */
package linkedlist2;

/** Find the starting point of the loop in a linked list
 * Approach:
 * 1. If a loop is found, initialize a slow pointer to head, let fast pointer be at its position. 
   2. Move both slow and fast pointers one node at a time. 
   3. The point at which they meet is the start of the loop.
 *
 */
public class FindFirstNodeOfLoopInList {

	static class Node {
		int val;
		Node next;

	}

	static Node newNode(int val) {
		Node temp = new Node();
		temp.val = val;
		temp.next = null;
		return temp;
	}

	// print linked list
	static void printList(Node head) {
		while (head != null) {
			System.out.println(head.val + "");
			head = head.next;
		}
		System.out.println();
	}

	// function to detect and remove loop
	static Node detectAndRemoveLoop(Node head) {
		// if the list is empty or have only one node without loop
		if (head == null || head.next == null) {
			return null;
		}
		Node slow = head, fast = head;
		
		// search for loop using slow & fast pointers
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
	
		}
		// if loop doesn't exist
		if (slow != fast) {
			return null;
		}
		// if loop exists reset slow to head
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;

		}
		return slow;
	}

	public static void main(String[] args) {
		Node head = newNode(50);
		head.next = newNode(20);
		head.next.next = newNode(15);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(10);

		// Create a loop for testing
		head.next.next.next.next.next = head.next.next;

		Node res = detectAndRemoveLoop(head);
		if (res == null)
			System.out.print("Loop does not exist");
		else
			System.out.print("Loop starting node is " + res.val);
	}

}


