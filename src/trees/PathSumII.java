/**
 * 
 */
package trees;

import java.util.ArrayList;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. 
 * Each path should be returned as a list of the node values, not node references.
  A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
  Example1:
  Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
  Output: [[5,4,11,2],[5,8,4,5]]
  Explanation: There are two paths whose sum equals targetSum:
  5 + 4 + 11 + 2 = 22
  5 + 8 + 4 + 5 = 22

 *
 */

public class PathSumII {
	static TreeNode root;
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static ArrayList<ArrayList<Integer>> solve(TreeNode root, int targetSum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		ArrayList<Integer> temp = new ArrayList<>();
		dfs(root, result, temp, 0, targetSum);
		return result;
	}

	public static void dfs(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int sum, int targetSum) {
		if (root == null) {
			return;
		}
		temp.add(root.val);
		if (root.left == null && root.right == null && root.val + sum == targetSum) {
			result.add(new ArrayList<>(temp));
		}
		dfs(root.left, result, temp, sum + root.val, targetSum);
		dfs(root.right, result, temp, sum + root.val, targetSum);
		temp.remove(temp.size() - 1);
		return;
	}
	public static void main(String[] args) {
		root = new TreeNode(5);
		root.left = new TreeNode(4);
	    root.right = new TreeNode(8);
	    root.left.left = new TreeNode(11);
	    root.left.left.left = new TreeNode(7);
	    root.left.left.right = new TreeNode(2);
	    root.right.left = new TreeNode(13);
	    root.right.right = new TreeNode(4);
	    root.right.right.left = new TreeNode(5);
	    root.right.right.right = new TreeNode(1);
	    int targetSum = 22;
	    System.out.println(solve(root, targetSum));
	    

	}

}
