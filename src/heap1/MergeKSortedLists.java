/**
 * 
 */
package heap1;

import java.util.PriorityQueue;

/**
 * Given K linked lists each of size N and each list is sorted in non-decreasing order,
 * merge them into a single sorted (non-decreasing order) linked list and print the sorted linked list as output.
 *
 */
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeKSortedLists {

	/**
	 * Approach:
	 * 
1.Create a min-heap and insert the first element of all the �k� linked lists.
2.As long as the min-heap is not empty, perform the following steps: 
3.Remove the Root of the min-heap (which is the current minimum among all the elements in the min-heap) and add it to the result list.
4.If there exists an element (in the same linked list) next to the element that popped out in the previous step, then insert it into the min-heap.
5.Return the head node address of the merged list.
	 */
	static ListNode mergeKList(ListNode[] lists) {
		int n = lists.length;
        if (lists == null || n == 0) return null;
        
        // Ensure our pq takes in ListNodes and compares their values.
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        
        // Add the head of all non-null lists to the pq to begin.
        for (ListNode list: lists)
            if (list != null) pq.add(list);
        
        // Dummy node pointer to help add to our output list.
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        // 1) Get the smallest node from the PriorityQueue.
        // 2) Add it to our output list.
        // 3) Add the next node of the current list to the pq if it's not null
        // 4) Repeat
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = new ListNode(curr.val);
            dummy = dummy.next;
            if (curr.next != null) pq.add(curr.next);
        }
        
        return head.next;
	}
	
	
	// Print linked list
    public static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
	
	public static void main(String[] args) {
		int N = 3;
		// array to store head of linkedlist
		ListNode[] a = new ListNode[N];
		// Linkedlist1
		ListNode head1 = new ListNode(1);
		a[0] = head1;
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);
		// Linkedlist2
		ListNode head2 = new ListNode(2);
		a[1] = head2;
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		head2.next.next.next = new ListNode(8);
		// Linkedlist3
		ListNode head3 = new ListNode(0);
		a[2] = head3;
		head3.next = new ListNode(9);
		head3.next.next = new ListNode(10);
		head3.next.next.next = new ListNode(11);

		ListNode res = mergeKList(a);

		if (res != null)
			printList(res);
		System.out.println();
	}

}
