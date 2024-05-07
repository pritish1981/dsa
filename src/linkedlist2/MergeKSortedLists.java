/**
 * 
 */
package linkedlist2;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
   Merge all the linked-lists into one sorted linked-list and return it.
 *
 */
public class MergeKSortedLists {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		//base condition
		if(lists == null || lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length-1);
	}
	
	public static ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if(start == end) {
			return lists[start];
		}
		int mid = start + (end-start)/2;
		ListNode left = mergeKLists(lists, start, mid);
		ListNode right = mergeKLists(lists, mid+1, end);
		//merge left & right sub-lists
		return merge(left, right);
	}
	
	public static ListNode merge(ListNode left, ListNode right) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while(left != null && right !=null) {
			if(left.val < right.val) {
				curr.next = left;
				left = left.next;
			}else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}
		if(left != null) {
			curr.next = left;
			left = left.next;
		}
		if(right != null) {
			curr.next = right;
			right = right.next;
		}
		return head.next;
	}
	
	//Time complexity: O(N * log k)
	//Space complexity: O(1)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
