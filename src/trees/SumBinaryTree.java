/**
 * 
 */
package trees;

/**
 * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present 
in its left subtree and right subtree.
An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
Return 1 if it sum-binary tree else return 0.
 *
 */
public class SumBinaryTree {
    static TreeNode root;
	public static int isLeaf(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return 0;
    }
	
    public static int isSumTree(TreeNode node) {
        int ls, rs;
        if (node == null || isLeaf(node) == 1)
            return 1;

        if (isSumTree(node.left) == 1 && isSumTree(node.right) == 1) {
            if (node.left == null)
                ls = 0;
            else if (isLeaf(node.left) == 1)
                ls = node.left.val;
            else
                ls = 2 * (node.left.val);
            
            if (node.right == null)
                rs = 0;
            else if (isLeaf(node.right) == 1)
                rs = node.right.val;
            else
                rs = 2 * (node.right.val);
            
            if (node.val == ls + rs)
                return 1;
            else
                return 0;
        }
        return 0;
    }

    public static int checksumtree(TreeNode root) {
        if (isSumTree(root) == 1) return 1;
        return 0;
    }
    
    public static int solve(TreeNode A) {
        return checksumtree(A);
    }
    
	public static void main(String[] args) {
		root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(3);
		System.out.println(solve(root));

	}

}
