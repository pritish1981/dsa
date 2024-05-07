/**
 * 
 */
package linkedlist2;

/**
 * Merge two sorted linked lists, A and B, and return it as a new list
 *
 */
public class MergeTwoSortedLinkedList {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp_node = new ListNode(0);
		ListNode cur_node = temp_node;
		while(l1 != null && l2 !=null) {
			if(l1.val < l2.val) {
				cur_node.next = l1;
				l1 = l1.next;
			}else {
				cur_node.next = l2;
				l2 = l2.next;
			}
			cur_node = cur_node.next;
		}
		if(l1 != null) {
			cur_node.next = l1;
			l1 = l1.next;
		}
		if(l2 != null) {
			cur_node.next = l2;
			l2 = l2.next;
		}
		return temp_node.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
