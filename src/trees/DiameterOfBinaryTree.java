/**
 * 
 */
package trees;

/**
 * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
 *
 */
public class DiameterOfBinaryTree {
    static TreeNode root;
	static int height(TreeNode root){
        // Base case: if the root is null, the height is 0
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        // Return the maximum depth of the current node by adding 1 to the maximum depth of its deepest subtree
        return Math.max(left,right)+1;
    }
	
	static int diameter(TreeNode root) {
		if(root == null) return 0;
		int dia1 = diameter(root.left);
		int dia2 = diameter(root.right);
		int dia3 = height(root.left) + height(root.right);
		return Math.max(dia3, Math.max(dia1, dia2));
	}
	public static void main(String[] args) {
		/*
        1
       / \
      2   3
     / \     
    4  5   

*/
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println("Diameter of a given biary tree is:" + diameter(root));

	}

}
