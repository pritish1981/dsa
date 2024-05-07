/**
 * 
 */
package trees;

/**
 * Find an element in a binary tree
 *
 */
public class FindElementInBinaryTree {
	static TreeNode root;
	static boolean search(TreeNode root, int k) {
		if(root == null) return false;
		if(root.val == k) return true;
		return search(root.left,k) || search(root.right,k);
	}
	
	public static void main(String[] args) {
		root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(15);
		root.left.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(17);
		//insert(root, 14);
		System.out.println(search(root,10));


	}

}
