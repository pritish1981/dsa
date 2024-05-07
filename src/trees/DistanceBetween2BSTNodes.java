/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class DistanceBetween2BSTNodes {

	static TreeNode lca(TreeNode root, int a, int b) {
		while(root != null) {
			if(a < root.val && b < root.val) {
				root = root.left;
			}else if(a > root.val && b > root.val) {
				root = root.right;
			}else {
				break;
			}
		}
		return root;
	}
	
	static int getDistance(TreeNode src, int dest) {
		if(src.val == dest) return 0;
		TreeNode node = src.left;
		if(src.val < dest) {
			node = src.right;
		}
		return 1 + getDistance(node, dest);
	}
	
	static int bstDistance(TreeNode root, int node1, int node2) {
		if(root == null) return -1;
		TreeNode lca = lca(root, node1, node2);
		return getDistance(lca, node1) + getDistance(lca, node2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
