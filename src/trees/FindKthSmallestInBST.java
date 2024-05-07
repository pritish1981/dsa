/**
 * 
 */
package trees;

import java.util.Stack;

/**
 * Given the root of a binary search tree and K as input, find Kth smallest element in BST. 
 *
 */
public class FindKthSmallestInBST {
	static class Node{
		int data;
		Node left,right;
		Node(int key){
			data = key;
			left = right = null;
		}
	}
	
	static Node insert(Node root, int key) {
		if(root == null)
			return new Node(key);
		if(key < root.data) {
			root.left = insert(root.left, key);
		}
		else if(key > root.data) {
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	static int findKthSmallest(Node root, int k) {
		Stack<Node> st = new Stack<>();
		while(root != null || !st.isEmpty()) {
			while(root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			if(--k == 0) {
				return root.data;
			}
			root = root.right;
		}
		return -1;
	}
	
	static int traversal(Node root, int k) {
		int count = 0;
		int ans = 0;
		if (root == null)
			return 0;
		traversal(root.left, k);
		count += 1;
		if (count == k) {
			ans = root.data;
		}
		traversal(root.right, k);
		return ans;
	}
	
	public static void main(String[] args) {
		Node root = null;
		int[] keys = {20, 8, 22, 4, 12, 10, 14};
		for(int x: keys) {
			root = insert(root, x);
		}
		int k = 4;
		int kthSmallest = findKthSmallest(root, k);
		if(kthSmallest != -1) {
			System.out.println("Kth-smallest element in BST is :: "+ kthSmallest);
		}else {
			System.out.println("Invalid input!!");
		}
	}

}
