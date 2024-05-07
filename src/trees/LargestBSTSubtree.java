/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class LargestBSTSubtree {

	public static int size(TreeNode root) {
		if(root == null) return 0;
		return size(root.left) + 1 + size(root.right);
	}
	
	public static boolean isBST(TreeNode node, int min, int max) {
		if(node == null) return true;
		//if nodes value falls outside the range
		if(node.val < min || node.val > max) return false;
		return isBST(node.left,min,node.val) && isBST(node.right,node.val,max);
	}
	
	// Recursive function to find the size of the largest BST in a given binary tree
	public static int findLargestBST(TreeNode root) {
		if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return size(root);
		}
		return Math.max(findLargestBST(root.left), findLargestBST(root.right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		 
        root.left = new TreeNode(15);
        root.right = new TreeNode(8);
 
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(20);
 
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
 
        System.out.println("The size of the largest BST is " + findLargestBST(root));

	}

}
