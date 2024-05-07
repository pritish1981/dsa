/**
 * 
 */
package trees;

/**
 * Java program to print all nodes at a distance k from given node
 *
 */
public class NodesAtKDisanceAwayFromTarget {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	static TreeNode root;
	/* Recursive function to print all the nodes at distance k in tree (or subtree) rooted with given root. */
	
	void printKDistanceNodeDown(TreeNode node, int k) {
		if(node == null || k<0) return; //base case
		//if we reach k distance node print it
		if(k == 0) {
			System.out.println(node.val + " ");
			return;
		}
		//recursion for left & right subtrees
		printKDistanceNodeDown(node.left, k-1);
		printKDistanceNodeDown(node.right, k-1);
		
	}
	// Prints all nodes at distance k from a given target node.
    // The k distant nodes may be upward or downward.This function
    // Returns distance of root from target node, it returns -1
    // if target node is not present in tree rooted with root.
	
	int printKdistanceNode(TreeNode node, TreeNode target, int k) {
		if (node == null)
			return -1; // base case
		// If target is same as root. Use the downward function
		// to print all nodes at distance k in subtree rooted with
		// target or root
		if (node == target) {
			printKDistanceNodeDown(node, k);
			return 0;
		}

		// recursion for left subtree
		int dl = printKdistanceNode(node.left, target, k);
		// Check if target node was found in left subtree
		if (dl != -1) {

			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from
			// target
			if (dl + 1 == k) {
				System.out.print(node.val);
				System.out.println("");
			}

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printKDistanceNodeDown(node.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left
		// subtree
		int dr = printKdistanceNode(node.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.val);
				System.out.println("");
			} else
				printKDistanceNodeDown(node.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}
	
	public static void main(String[] args) {
		NodesAtKDisanceAwayFromTarget tree = new NodesAtKDisanceAwayFromTarget();
		  
        /* Let us construct the tree shown in above diagram */
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        TreeNode target = tree.root.left.right;
        tree.printKdistanceNode(tree.root, target, 2);

	}

}
