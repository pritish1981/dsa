/**
 * 
 */
package linkedlist2;

/**
 * A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
  Return a deep copy of the list.
 *
 */
public class CopyListWithRandomPointer {

	/**
	 * Solution Approach:
	 * 1.Insert cloned nodes in the original linked list.
	 * 2.Set random pointers of the cloned nodes.
	 * 3. Separate original & cloned linked lists.
	 */
	class Node {
		int val;
		Node next, random;
		Node(int x) {
			this.val = x;
		}
	};
	
	public Node copyRandomList(Node head) {
		if(head == null) return head;
	    Node temp=head;
	    
	    // step 1:Insert cloned nodes in the original linked list.
	    while(temp !=null && temp.next != null ){
	        Node nn=new Node(temp.val);
	        nn.next = temp.next;
	        temp.next = nn;
	        temp=temp.next.next;//update temp
	    }
	    temp.next=new Node(temp.val);
	    
	    //step 2: set random pointers of the cloned nodes
	    temp = head;
	    while(temp != null && temp.next != null){
	        if(temp.random != null){
	            temp.next.random=temp.random.next;
	        }
	        temp=temp.next.next;
	    }
	    
		//step3:Separate original & cloned linked lists
	    
		Node head2 = head.next;
		Node t1 = head;
		Node t2 = head2;
		while(t1.next!=null && t2.next !=null) {
			t1.next = t1.next.next;
			t2.next = t2.next.next;
			t1 = t1.next;
			t2 = t2.next;
		}
		t1.next = null;
		
		return head2;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
