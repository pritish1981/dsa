/**
 * 
 */
package trees;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum
 *
 */
public class PathSum {
    static TreeNode root;
	static boolean check(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }
        else{
            return check(root.left, sum - root.val) || check(root.right, sum - root.val);
        }
    }
	
	static int hasPathSum(TreeNode root, int sum) {
        if(check(root, sum) == true) return 1;
        return 0;
    }
	
	public static void main(String[] args) {
	/*	Tree:
	 *   5
        / \
       4   8
      /   / \
     11  13  4
    /  \      \
   7    2      1

B = 22
*/
    root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);
    int B = 22;
    System.out.println(hasPathSum(root,B));
    
    
	}

}
