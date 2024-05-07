/**
 * 
 */
package trees;

/**
 *Given two binary trees, check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 */
public class IdenticalBinaryTree {
    static TreeNode root1;
    static TreeNode root2;
	static boolean isIdentical(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null) return true;
		else if(node1 == null || node2 == null) return false;
		return ((node1.val == node2.val) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
	}
	
	static int identical(TreeNode A, TreeNode B) {
	       if(isIdentical(A, B) == true) return 1;
			return 0; 
	    }
	
	public static void main(String[] args) {
		root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		
		root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		/*
		 *       1       1
                / \     / \
               2   3   2   3
		 */
		
		System.out.println(identical(root1, root2));
		

	}

}
