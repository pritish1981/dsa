/**
 * 
 */
package trees;

/**
 * Given a binary tree check if its is balanced or not.
 * For balanced binary tree for all nodes
 * |height of left child| - |height of right child| <= 1.
 *
 */
public class BalancedBinaryTree {
	static Node root;

	@SuppressWarnings("unused")
	static int height(Node root) {
		boolean isBalanced = true;
		if(root == null) return -1;
		int lh = height(root.left);
		int rh = height(root.right);
		if(Math.abs(lh -rh) > 1) {
			isBalanced = false;
		}
		return Math.max(lh,rh)+1;
	}
	
	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		height(root);
		System.out.println(height(root));

	}

}
