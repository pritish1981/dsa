/**
 * 
 */
package linkedlist1;

/**
 * Given a singly linked list Head and an integer K, reverse the nodes of the list K at a time and return the modified linked list.
 *
 */
public class KReverseLinkedList {

	Node head; // head of list
	  
    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    Node reverse(Node head, int k)
    {
        if(head == null) return null;
        Node current = head;
        Node next = null;
        Node prev = null;
  
        int count = 0;
  
        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
  
        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);
  
        // prev is now head of input list
        return prev;
    }
    
    /* Utility functions */
    
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
  
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
  
	public static void main(String[] args) {
		KReverseLinkedList list = new KReverseLinkedList();
		/* Constructed Linked List is 1->2->3->4->5->6->
        7->8->8->9->null */
		list.push(9);
		list.push(8);
		list.push(7);
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

     System.out.println("Given Linked List");
     list.printList();

     list.head = list.reverse(list.head, 3);

     System.out.println("Reversed list");
     list.printList();

	}

}
