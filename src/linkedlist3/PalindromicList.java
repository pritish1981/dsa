/**
 * 
 */
package linkedlist3;

/**
 * @author Pritish
 *
 */
public class PalindromicList {

	class Node {
		int data;
		Node next;

		// a non-parameterized constructor.
		Node(int data) {
			this.data = data;
			this.next = null;
		}

		// a non-parameterized constructor.
		Node() {
		}
	}
	
	static Node reverseList(Node head) {
        Node previous = null;
        Node next = null;
        // traversing the list till the end.
        while (head != null) {
            // making a pointer point to the next node of the current node.
            next = head.next;
            head.next = previous;
            // making the previous node point to the current node.
            previous = head;
            // moving the current node.
            head = next;
        }
        return previous;
    }
	
	// a function that will check if the linked list is a palindrome linked list or not.
    static boolean checkPalindrome(Node head) {
        // base case.
        if (head == null || head.next == null)
        return true;

        // using the two-pointer technique to get the middle element.
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null)  {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow pointer is pointing to the middle element, so reversing the list after the middle element.
        slow.next = reverseList(slow.next);
        slow = slow.next;
        Node temporary = head;

        // checking the values of the modified.
        while (slow != null) {
            if (temporary.data != slow.data)
                return false;
            temporary = temporary.next;
            slow = slow.next;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
