/**
 * 
 */
package linkedlist3;

/**
 * Solution Approach:
 * 1.Recursively call to merge the current linked list with the next linked list
   2.If the current linked list is empty or there is no next linked list then return the current linked list (Base Case)
   3.Start merging the linked lists, starting from the last linked list
   4.After merging the current linked list with the next linked list, return the head node of the current linked list
 *
 */
public class FlatteningLinkedList {
	Node head; // head of list

	/* Linked list Node*/
	class Node {
		int data;
		Node right, down;
		Node(int data) {
			this.data = data;
			right = null;
			down = null;
		}
	}

	// An utility function to merge two sorted linked lists
	Node merge(Node a, Node b) {
		
		if (a == null) return b;
		if (b == null) 	return a;

		// compare the data members of the two linked lists and put the larger one in the result
		Node result;

		if (a.data < b.data) {
			result = a;
			result.down = merge(a.down, b);
		}
		else {
			result = b;
			result.down = merge(a, b.down);
		}
		result.right = null;
		return result;
	}

	Node flatten(Node root) {
		// Base Cases
		if (root == null || root.right == null)
			return root;

		// recur for list on right
		root.right = flatten(root.right);

		// now merge
		root = merge(root, root.right);

		// return the root
		// it will be in turn merged with its left
		return root;
	}

	/*
	 * Utility function to insert a node at beginning of the linked list
	 */
	Node push(Node node, int data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(data);

		/* 3. Make next of new Node as head */
		new_node.down = node;

		/* 4. Move the head to point to new Node */
		node = new_node;

		/* 5. return to link it back */
		return node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.down;
		}
		System.out.println();
	}

	// Driver's code
	public static void main(String args[]) {
		FlatteningLinkedList L = new FlatteningLinkedList();

		/* Let us create the following linked list
        5 -> 10 -> 19 -> 28
        |    |     |     |
        V    V     V     V
        7    20    22    35
        |          |     |
        V          V     V
        8          50    40
        |                |
        V                V
        30               45
    */

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.right = L.push(L.head.right, 20);
		L.head.right = L.push(L.head.right, 10);

		L.head.right.right = L.push(L.head.right.right, 50);
		L.head.right.right = L.push(L.head.right.right, 22);
		L.head.right.right = L.push(L.head.right.right, 19);

		L.head.right.right.right = L.push(L.head.right.right.right, 45);
		L.head.right.right.right = L.push(L.head.right.right.right, 40);
		L.head.right.right.right = L.push(L.head.right.right.right, 35);
		L.head.right.right.right = L.push(L.head.right.right.right, 20);

		// Function call
		L.head = L.flatten(L.head);

		L.printList();
	}
}
