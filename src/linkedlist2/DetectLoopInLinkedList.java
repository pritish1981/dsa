/**
 * 
 */
package linkedlist2;

/**
 * @author User
 *
 */
public class DetectLoopInLinkedList {
	Node head; // head of list

	class Node {
		int val;
		Node next;

		Node(int x) {
			val = x;
			next = null;
		}
	}

	// insert a new node at the front of the list
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;// make next of new node as head
		head = new_node;// move head to point to new node
	}

	void detectLoop() {
		Node slow = head;
		Node fast = head;
		int flag = 0;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.println("Loop is found !");
		} else {
			System.out.println("No Loop !!");
		}
	}

	public static void main(String[] args) {
		DetectLoopInLinkedList list = new DetectLoopInLinkedList();
		list.push(20);
		list.push(4);
		list.push(15);
		list.push(10);
		// create a loop for testing
		list.head.next.next.next.next = list.head;
		list.detectLoop();

	}

}
