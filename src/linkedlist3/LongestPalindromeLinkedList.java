/**
 * 
 */
package linkedlist3;

/**
 * Find the length of longest palindrome in a linked list
 *
 */
public class LongestPalindromeLinkedList {

	/**
	 * Solution: Reverse the linked list while traversing
	 */
	static class Node
	{
	    int data;
	    Node next;
	}
	
	//Function for counting the matching elements from both sides
	static int countMatching(Node prev, Node temp) {
		int count = 0;
		for(;prev!=null && temp!=null;prev = prev.next, temp = temp.next) {
			//increment the count for same values
			if(prev.data == temp.data)
				count++;
			else 
				break;
		}
		return count;
	}
	
	//return length of longest palindromic substring in the given list
	static int maxLengthPalindrome(Node head) {
		int ans = 0;
		Node prev = null, curr = head;
		while(curr !=null) {
			Node temp = curr.next;
			curr.next = prev;// pointer from curr to prev is reversed
			//check for odd length palindrom by finding matching elements starting from prev to temp
			ans = Math.max(ans,  2*countMatching(prev,temp)+1);
			//even length pallindrom by finding matching elements starting from curr to temp
			ans = Math.max(ans, 2*countMatching(curr, temp));
			// update prev & curr for next iteration
			
			prev = curr;
			curr = temp;
		}
		return ans;
	}
	
	// Utility function to create a new list node
	static Node newNode(int key)
	{
	    Node temp = new Node();
	    temp.data = key;
	    temp.next = null;
	    return temp;
	}
	
	
	
	public static void main(String[] args) {
		/* Let us create a linked lists to test   the functions
	    Created list is a: 2->4->3->4->2->15 */
	    Node head = newNode(2);
	    head.next = newNode(4);
	    head.next.next = newNode(3);
	    head.next.next.next = newNode(4);
	    head.next.next.next.next = newNode(2);
	    head.next.next.next.next.next = newNode(15);
	 
	    System.out.println("Max length of palindrom in a list is: "+maxLengthPalindrome(head));

	}

}
