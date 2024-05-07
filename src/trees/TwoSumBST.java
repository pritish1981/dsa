/**
 * 
 */
package trees;

import java.util.Stack;

/**
 * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist 
 * two different nodes X and Y such that X.value + Y.value = B. Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 */
public class TwoSumBST {
    static TreeNode root;
	static boolean isPairPresent(TreeNode root, int target) {
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		TreeNode cur1 = root;
		TreeNode cur2 = root;
		while (cur1 != null || cur2 != null || !st1.isEmpty() || !st2.isEmpty()) {
			if (cur1 != null || cur2 != null) {
				if (cur1 != null) {
					st1.push(cur1);
					cur1 = cur1.left;
				} else if (cur2 != null) {
					st2.push(cur2);
					cur2 = cur2.right;
				}
			} else if (st1.isEmpty() || st2.isEmpty()) {
				break;
			}

			else {
				TreeNode node1 = st1.peek();
				TreeNode node2 = st2.peek();
				if (node1.val == node2.val) return false;
				else if (node1.val + node2.val == target) return true;
				else if (node1.val + node2.val < target) {
					st1.pop();
					cur1 = node1.right;
				} else {
					st2.pop();
					cur2 = node2.left;
				}
			}
		}
		return false;
	}
	
	static int pairPresent (TreeNode root, int target) {
		if(isPairPresent(root, target)) {
			return 1;
		}else {
			return 0;
		}
	}
	public static void main(String[] args) {
		root = new TreeNode(25);
		root.left = new TreeNode(12);
		root.right = new TreeNode(37);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(20);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(40);
		int target = 50;
		System.out.println(pairPresent(root, target));

	}

}
