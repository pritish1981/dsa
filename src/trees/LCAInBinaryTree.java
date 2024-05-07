/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		val = x;
		left = null;
		right = null;
	}
}

public class LCAInBinaryTree {
	static TreeNode root;

	

	public static TreeNode findLCA(TreeNode root, int p, int q) {
		if (root == null) return null;
		if (root.val == p || root.val== q) return root;
		TreeNode left = findLCA(root.left, p, q);
		TreeNode right = findLCA(root.right, p, q);
		if(left == null) return right;
		else if(right == null) return left;
		else return root;

	}

	public static void main(String[] args) {
		LCAInBinaryTree tree = new LCAInBinaryTree();
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("LCA(4, 5) = " + tree.findLCA(root, 4, 5).val);
		

	}

}
