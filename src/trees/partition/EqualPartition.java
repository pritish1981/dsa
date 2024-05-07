/**
 * 
 */
package trees.partition;

/**
 * @author Pritish
 *
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	TreeNode (int x){
		val = x;
		left = null;
		right = null;
		next = null;
	}
}
public class EqualPartition {
    static TreeNode root;
    static int sum;
    static boolean partitionFlag;
    
	public static int findSum(TreeNode root) {
		if(root == null) return 0;
		int left = findSum(root.left);
		int right = findSum(root.right);
		double currentSum = left + right + root.val;
		if(currentSum == sum/2) {
			partitionFlag = true;
		}
		return (int)currentSum;
	}
	
	public static boolean checkEqualTree(TreeNode root) {
		if (root == null) return false;
		sum = findSum(root);
		partitionFlag = false;
		findSum(root.left);
		findSum(root.right);
		return partitionFlag;
	}
	
	public static int solve(TreeNode A) {
		if(checkEqualTree(A) == true) return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		/*
        5                                                 6
      /  \                                               /  \
     10  10                                             9    4
    / \                                                     /
   2   3                                                    8
                                                            \
                                                             3
      

*/
		root = new TreeNode(6);
		root.left = new TreeNode(9);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(8);
		root.right.left.right = new TreeNode(3);
		
		System.out.println(solve(root));

	}

}
