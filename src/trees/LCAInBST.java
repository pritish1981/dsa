 /**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class LCAInBST {

	static TreeNode root;
	static int lca(TreeNode root, int n1, int n2) {
		while(root != null) {
			if(n1 < root.val && n2 < root.val) {
				root = root.left;
			}
			else if(n1 > root.val && n2 > root.val) {
				root = root.right;
			}else {
				break;
			}
		}
		return root.val;
	}
	
	public static void main(String[] args) {
		LCAInBST tree = new LCAInBST();
		tree.root = new TreeNode(20);
		tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        int n1 = 10, n2 = 14;
        int node = tree.lca(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is "+ node);

	}
//T.C: O(H),S.c:O(H)
}
