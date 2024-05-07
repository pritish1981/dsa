
package trees;

import java.util.Stack;

/**
 * @author Pritish
 *
 */
public class ZigZagLevelOrderTraversal {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
     static TreeNode root;
     //using stack
		// O(N) time | O(1) space
		public static void printZigzagLevelOrderTraversal(TreeNode root) {
			Stack<TreeNode> curr = new Stack<>();
			Stack<TreeNode> next = new Stack<>();
			curr.push(root);
			int level = 0;
			while (!curr.isEmpty()) {
				while (!curr.isEmpty()) {
					TreeNode node = curr.pop();
					System.out.print(node.val + " ");
					if (level % 2 == 0) {
						if (node.left != null)
							next.push(node.left);
						if (node.right != null)
							next.push(node.right);
					} else {
						if (node.right != null)
							next.push(node.right);
						if (node.left != null)
							next.push(node.left);
					}
				}
				System.out.println();
				level++;
				curr = next;
				next = new Stack<>();
			}
		}
		
		
		public static void main(String[] args) {
			root = new TreeNode(10);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(7);
			root.left.right = new TreeNode(8);
			root.right.left = new TreeNode(12);
			root.right.right = new TreeNode(15);
			System.out.println("Zigzag level order traversal is::");
			ZigZagLevelOrderTraversal zt = new ZigZagLevelOrderTraversal();
			zt.printZigzagLevelOrderTraversal(root);
		}

}
