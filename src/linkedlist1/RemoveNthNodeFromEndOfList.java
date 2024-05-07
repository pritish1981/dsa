/**
 * 
 */
package linkedlist1;

/**
 * @author Pritish
 *
 */

public class RemoveNthNodeFromEndOfList {

	static class Node {
		int val;
		Node next;
	}

	static void printList(Node head) {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.val + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}

	static Node newNode(int data) {
		Node new_node = new Node();
		new_node.val = data;
		new_node.next = null;
		return new_node;
	}

	static Node removeNthFromEnd(Node head, int n) {
		Node start = new Node();
		start.next = head;
		Node fast = start;
		Node slow = start;

		for (int i = 1; i <= n; ++i)
			fast = fast.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return start.next;
	}

	public static void main(String[] args) {
		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);
		System.out.println("Linked List before Deletion:");
		printList(head);

		head = removeNthFromEnd(head, 2);

		System.out.println("Linked List after Deletion:");
		printList(head);
	}
}
