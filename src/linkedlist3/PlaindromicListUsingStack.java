/**
 * 
 */
package linkedlist3;

import java.util.Stack;

/**
 * 1.Initialize an empty stack.
   2.Start traversing the list from the head node and push the elements into the stack one after the other.
   3.Traverse the stack for the second time and check whether the currently visited node is the same at the top of the stack or not.
      If they are the same then pop the top element of the stack, and move to the next element of the linked list.
      Else, the linked list is not a palindrome linked list.
   4.Continue the above steps until the entire list is traversed or until a mismatch is found.
 *
 */
public class PlaindromicListUsingStack {

	class Node {
	    int data;
	    Node next;
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	// a function that will check if the linked list is a palindrome linked list or not.
    static boolean checkPalindrome(Node head) {
        // a pointer that will help us to traverse the linked list.
        Node currentPointer = head;
        boolean isPalindrome = true;

        // initialize a stack data structure.
        Stack<Integer> stack = new Stack<Integer>();

        // Pushing the elements of the linked list to the stack.
        while (currentPointer != null) {
            stack.push(currentPointer.data);
            currentPointer = currentPointer.next;
        }

        // Iterating the list again and checking if the top of the stack is the same as the current element or not.
        while (head != null) {
            // getting the top element for comparison.
            int i = stack.pop();


            // Checking the top element and current element are the same or not.
            if (head.data == i) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }
    
    public static void main(String args[]) {
        // an array containing the data of the linked list.
        int[] data = { 1, 2, 3, 2, 1 };

        // creating the head pointer
        Node head = null;

		/*
		 * // constructing the linked list from last to first for (int i = data.length -
		 * 1; i >= 0; i--) { // head = new Node(data[i], head); }
		 */

        if (checkPalindrome(head))
            System.out.println("The linked list is a palindrome linked list.");
        else
            System.out.println("The linked list is not a palindrome linked list.");

    }

}
