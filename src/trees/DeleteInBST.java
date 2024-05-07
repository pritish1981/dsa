/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class DeleteInBST {

	static TreeNode delete(TreeNode root, int key) {
		while (root != null) {
			if (key < root.val)
				root.left = delete(root.left, key);
			else if (key > root.val)
				root.right = delete(root.right, key);
			else {
				//case 1: leaf node
				if (root.left == null && root.right == null)
					return null;
				//case 2: Node has single child
				if (root.left == null || root.right == null)
					return root.left != null ? root.left : root.right;
                //case 3: Node has 2 child
				//max of left sub tree
				TreeNode temp = root.left;
				while (temp.right != null)
					temp = temp.right;
				root.val = temp.val;
				root.left = delete(root.left, temp.val);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
