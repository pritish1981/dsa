/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class SortedArrayToBalancedBST {

	static TreeNode root;
	
	public TreeNode sortedArrayToBST(final int[] nums) {
		return helper(nums, 0, nums.length-1);
	}

	static TreeNode helper(int[] arr, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		/* Recursively construct the left subtree and make it left child of root */
		node.left = helper(arr, start, mid - 1);
		node.right = helper(arr, mid + 1, end);
		return node;
	}

	/*
	 * A utility function to print preorder traversal of BST
	 */
	void preOrder(TreeNode node) {
		if (node == null) return;
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		root = tree.sortedArrayToBST(arr);
		System.out.println("Preorder traversal of constructed BST");
		tree.preOrder(root);

	}

}
