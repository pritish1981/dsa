/**
 * 
 */
package linkedlist3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pritish
 *
 */
public class LRUCache {
	
	    //Size denotes the current size of the List while capacity is the maximum size list is allowed to take.
		static int size, capacity;
		// Head and tail are the dummy nodes, to implement the queue.
		static Node head, tail;
		// 'map' is the Hash that will map the 'key' to 'Nodes'.
		static Map<Integer, Node> map;


	// Node class that denotes the node of doubly linked list.
	static class Node {
		// key and val store the Key-Value pair.
		int key, val;
		// Next and prev are the address of next and previous nodes.
		Node next, prev;
		// Constructor to initialize the key and val.
		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	// Function to add the node next to the head of the List.
	static void addNode(Node node) {
		// Assigning the address of head to node's previous pointer.
		node.prev = head;
		// Assigning the address of head's nextto node's next pointer.
		node.next = head.next;
		// Now making node to be head's next.
		head.next = node;
		// Then, make node's next's previous to be node.
		node.next.prev = node;
	}

	// Function to remove the 'node' from the list.
	static void removeNode(Node node) {
		// Changing address of previous and next pointer.
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	// Function to move 'node' to head of the List.
	static void moveToHead(Node node) {
		// Remove it from it current position.
		removeNode(node);
		// Add it to head.
		addNode(node);
	}

	// Function to remove node at the tail of the List.
	static Node popTail() {
		// Store the result in 'ret'.
		Node ret = tail.prev;
		// Remove 'ret'
		removeNode(ret);
		// Return 'ret'.
		return ret;
	}

	
	// Functiion to initialize the values.
	static void lruCache(int capacity) {
		// Defining dummy head and tail nodes.
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;

		// Initial size is 0.
		LRUCache.size = 0;
		LRUCache.capacity = capacity;

		// Initializing the 'map'.
		map = new HashMap<>();
	}

	// Function to get value with Key as 'key'.
	static int get(int key) {
		// Checking in the 'map' for the 'node' with Key as 'key'.
		Node node = map.get(key);

		// If no such node exists in 'map' Return -1.
		if (node == null)
			return -1;

		/// Otherwise move it to the head.
		moveToHead(node);

		// Returning the value associated with 'node'.
		return node.val;
	}

	// Function to put a Key-Value pair in Cache.
	static void put(int key, int value) {

		// Checking if 'map' already contains a node with Key as 'key'.
		Node node = map.get(key);
		// If it do not exists.
		if (node == null) {
			// Defining a new node that will be inserted in the cache.
			Node newNode = new Node(key, value);
			// Putting in 'map'.
			map.put(key, newNode);
			// Adding it to head of list.
			addNode(newNode);
			// Increasing the size of the list.
			size++;
			// If after adding, 'size' exceeds the capacity.
			if (size > capacity) {
				// Remove the node at tail, because it is the least recently used.
				Node temp = popTail();
				map.remove(temp.key);
				// Reducing the size by 1.
				size--;
			}
		}
		// Otherwise if it exists.
		else {
			// Update the value.
			node.val = value;
			// Move the node to head of the list.
			moveToHead(node);
		}
	}

	// Main function.
	public static void main(String args[]) {
		// Initializing the cache, with capacity 3.
		lruCache(3);

		// Performing operations.
		put(1, 1);
		put(2, 2);
		put(3, 3);

		System.out.println(get(2));
		System.out.println(get(1));

		put(4, 4);

		System.out.println(get(1));
		System.out.println(get(2));

		put(5, 5);

		System.out.println(get(3));

	}

}
