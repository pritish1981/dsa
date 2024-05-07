/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class SumOfLeafNodesInBinaryTree {
  
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	static int sum;

	static int leafSum(Node root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			sum += root.data;
		}
		leafSum(root.left);
		leafSum(root.right);
		return sum;
	}
	
	public static void main(String[] args) {
		
	   /*	
		    1
	      /   \
	     2     3
	    / \   / \
	   4   5 6   7
	   
	   */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		sum = 0;
		leafSum(root);
		System.out.print(sum);
	}

}
