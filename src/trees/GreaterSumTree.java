/**
 * 
 */
package trees;

/**
 * Given root of BST of size N with distinct values. Transform it into a "greater sum tree" i.e  each node in the new tree
 * has a value equal to the original tree node values plus the sum of all values greater than the original node value in the tree.
 * Return new tree formed.
 *
 */
public class GreaterSumTree {

	static TreeNode root;
	static int ans = 0;
	static TreeNode greaterSumTree(TreeNode root) {
		if(root != null) {
			greaterSumTree(root.right);
			ans += root.val;
			root.val = ans;
			greaterSumTree(root.left);
		}
		return root;
	}
	public static void main(String[] args) {
		root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		System.out.println(greaterSumTree(root));
		

	}

}
