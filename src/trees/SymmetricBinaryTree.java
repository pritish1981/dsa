/**
 * 
 */
package trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 */
public class SymmetricBinaryTree {
    static TreeNode root;
	static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
	
	static boolean isSymmetricCheck(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
	
	static int isSymmetric(TreeNode A) {
        if(isSymmetricCheck(A) == true) return 1;
        return 0;
    }
	public static void main(String[] args) {
		/*
        1
       / \
      2    2
     / \   /\   
    3   4 4  3
*/
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(root));

	}

}
