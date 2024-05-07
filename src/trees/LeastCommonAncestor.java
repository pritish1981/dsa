/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class LeastCommonAncestor {

	public static TreeNode LCA(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;
        TreeNode l = LCA(root.left, a, b);
        TreeNode r = LCA(root.right, a, b);
        if (l != null && r != null) return root;
        return l != null ? l : r;
    }
    public static boolean find(TreeNode root, int a) {
        if (root == null) return false;
        if (root.val == a) return true;
        return (find(root.left, a) || find(root.right, a));
    }
    public int lca(TreeNode root, int B, int C) {
        if (find(root, B) == false || find(root, C) == false) 
            return -1;
        TreeNode ans = LCA(root, B, C);
        if (ans == null) 
            return -1;
        return ans.val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
