/**
 * 
 */
package trees.partition;

import java.util.HashMap;
import java.util.Map;

/**
 *Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal
 *sum of values after removing exactly one edge on the original tree.
 *
 */
public class EqualTreePartition {
    static TreeNode root;
	public static long populate(TreeNode root, Map<Long, Integer> map) {
		if (root == null) return 0;
		long sum = root.val + populate(root.left, map) + populate(root.right, map);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		return sum;
	}

	public static int solve(TreeNode root) {
		Map<Long, Integer> map = new HashMap<>();
		long tot = populate(root, map);
		// since total sum can also be zero
		if (tot == 0)
			return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
		return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
	}

	public static void main(String[] args) {
		
		/*
         5
       /  \
      3    7
     / \  /\   
    4  6 5  6

*/

		root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println(solve(root));

	}

}
