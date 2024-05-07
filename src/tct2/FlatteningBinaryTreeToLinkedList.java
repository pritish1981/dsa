/**
 * 
 */
package tct2;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 *
 */


public class FlatteningBinaryTreeToLinkedList {

	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
    //Using Morris traversal having Time Complexity: O(n), Space complexity: O(1)
	
	public static void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode temp = root.left;
				while (temp.right != null)
					temp = temp.right;
				temp.right = root.right;
				root.right = root.left;
				root.left = null;

			}
			root = root.right;
		}
	}

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		flatten(root);
		while (root.right != null) {
			System.out.print(root.data + "->");
			root = root.right;
		}
		System.out.print(root.data);
	}

}
