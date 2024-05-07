/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */

public class InvertBinaryTree {

	static TreeNode root;
	static TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		//swap left & right child
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	//preorder traversal of tree
	static void preorder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + ",");
		preorder(root.left);
		preorder(root.right);
	}
	public static void main(String[] args) {
		/*
		         1
		        / \
		       2   3
		      / \  /\   
		     4  5 6  7
		
		 */
		
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		invertTree(root);
		preorder(root);
		//output: 1,3,7,6,2,5,4,
		
	}

}
