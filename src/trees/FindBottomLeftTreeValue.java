/**
 * 
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the left most value in the last row of the tree.
 *
 */
public class FindBottomLeftTreeValue {
    static TreeNode root;
	static int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int size = q.size();
			min = q.peek().val;
			for(int i=0;i< size;i++) {
				TreeNode node = q.poll();
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}
		}
		return min;
	}
	public static void main(String[] args) {
		
	/*	2
	   / \
      6   3
      output: 1
    */
	root = new TreeNode(2);
	root.left = new TreeNode(6);
	root.right = new TreeNode(3);
	System.out.println(findBottomLeftValue(root));
	}

}
