/**
 * 
 */
package trees.partition;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pritish
 *
 */
public class PartitionTree {
    static TreeNode root;
	static int findSum(TreeNode root, Set<Integer> set) {
		if(root == null) return 0;
		int sum = root.val + findSum(root.left, set) + findSum(root.right, set);
		set.add(sum);
		return sum;
	}
	
	static boolean checkEqualTree(TreeNode root) {
		if(root == null) return false;
		Set<Integer> set = new HashSet<>();
		double sum = root.val + findSum(root.left, set) + findSum(root.right, set);
		return sum %2 == 0 && set.contains((int)sum/2);
	}
	
	public static int solve(TreeNode A) {
		if(checkEqualTree(A) == true) return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		root = new TreeNode(6);
		root.left = new TreeNode(9);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(8);
		root.right.left.right = new TreeNode(3);
		System.out.println(solve(root));
	}

}
