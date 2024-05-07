/**
 * 
 */
package trees;

/**
 * Check if the given binary tree is valid BST or not.
 *
 */
public class ValidateBST {


	public static boolean isValid(TreeNode root, int min, int max) {
		if (root == null) return true;
		// if nodes value falls outside the range
		if (root.val <= min || root.val >= max) return false;
		boolean left = isValid(root.left, min, root.val);
		if(left) {
			boolean right = isValid(root.right, root.val, max);
			return right;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
