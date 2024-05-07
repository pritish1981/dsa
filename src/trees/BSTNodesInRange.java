/**
 * 
 */
package trees;

/**
 * Given the head of a Binary Search Tree (BST) and a range (l, h), count the number of nodes that lie in the given range (l, h).
 *
 */
public class BSTNodesInRange {
static TreeNode root;
	public static int  nodesInRange(TreeNode node, int low, int high) {
		if(node == null) return 0;
		//If current node is in range, then include it in count and recur for left and right children of it
		if(node.val >= low && node.val <= high) {
			return 1 + nodesInRange(node.left, low, high) + nodesInRange(node.right, low, high);
		}
		// If current node is smaller than low,then recur for right child
		else if(node.val < low) {
			return nodesInRange(node.right, low, high);
		}
		else {// recur for left child
			return nodesInRange(node.left, low, high);
		}
	}
	public static void main(String[] args) {
		BSTNodesInRange tree = new BSTNodesInRange();
		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(50);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(100);
		int low=5;
	    int high=45;
	    System.out.println("count of nodes between [" + low +","+ high + "] is : " + tree.nodesInRange(root, low, high));
		

	}

}
