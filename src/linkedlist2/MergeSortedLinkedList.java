/**
 * 
 */
package linkedlist2;

/**
 * @author Pritish
 *
 */
public class MergeSortedLinkedList {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode sortList(ListNode A) {
		 if (A == null || A.next == null) {
	            return A;
	        }
		// Find the middle of the list using the slow and fast pointer approach
	        ListNode slow = A, fast = A.next;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	     // Split the list into two halves at the middle node
	        ListNode mid = slow.next;
	        slow.next = null;
	        
	     // Recursively sort the two halves of the list
	        ListNode left = sortList(A);
	        ListNode right = sortList(mid);
	        // Merge the two sorted halves of the list
	        return merge(left, right);
	    }
	 
	// Merge two sorted linked lists into a single sorted linked list
	    private ListNode merge(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(0);
	        ListNode curr = dummy;
	        // Compare the values of the nodes in l1 and l2 and add the smaller value to the merged list
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	                curr.next = l1;
	                l1 = l1.next;
	            } else {
	                curr.next = l2;
	                l2 = l2.next;
	            }
	            curr = curr.next;
	        }
	        // Add the remaining nodes of l1 or l2 to the merged list
	        if (l1 != null) {
	            curr.next = l1;
	        } else {
	            curr.next = l2;
	        }
	        return dummy.next;
	    }
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
