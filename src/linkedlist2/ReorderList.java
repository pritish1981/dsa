/**
 * 
 */
package linkedlist2;

/**
 * Input: A = [1, 2, 3, 4, 5] 
 * Output:A = [1, 5, 2, 4, 3]
 * Approach
1). Find the middle element(slow & fast Algo).
2). 2nd half reverse.
3). Alternate merging.

Time complexity: O(n)
Space complexity: O(1)
 *
 */
public class ReorderList {

	static class ListNode {
        int data;
        ListNode next;
    }
	
	static ListNode reverse (ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	static ListNode reorderList(ListNode head) {
		//step1: Find middle of the linked list using slow/fast pointer approach
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//step2: reverse the 2nd half & split the list into two
		ListNode second = reverse(slow.next); // second list
		slow.next = null; // break the link to 2nd half
		ListNode first = head; // first list
		
		//step3: merging the two lists
		while(second != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = second.next; 
			first.next = second;
			second.next = temp1;
			first = temp1;
			second = temp2;
		}
		return head;
	}
	
	// Utility function to create a new list node
		static ListNode newNode(int data)
	    {
	        ListNode new_node = new ListNode();
	        new_node.data = data;
	        new_node.next = null;
	        return new_node;
	    }
		
		/* Function to print linked list */
	    static void printList(ListNode head)
	    {
	        ListNode temp = head;
	        while (temp != null) {
	            System.out.print(temp.data + "->");
	            temp = temp.next;
	        }
	    }
			
		public static void main(String[] args) {
			ListNode head = newNode(1);
		    head.next = newNode(2);
		    head.next.next = newNode(3);
		    head.next.next.next = newNode(4);
		    head.next.next.next.next = newNode(5);
		    
	        head = reorderList(head);
	        printList(head);
		}

}
