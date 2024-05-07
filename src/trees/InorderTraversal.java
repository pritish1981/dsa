/**
 * 
 */
package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * NOTE: Using recursion is not allowed.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the inorder traversal of the given binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [6, 1, 3, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 *
 *  The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */

/**
 *  public static class Node {
 *         public int val;
 *         public Node next;
 *
 *         Node(int x) {
 *             val = x;
 *             next = null;
 *         }
 *     }
 */
public class InorderTraversal {
	static TreeNode root;
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) {
		       val = x;
		       left=null;
		       right=null;
		      }
		  }

	
	//Recursive Approach
	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}
	//iterative approach
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> st = new Stack<>();
		//TreeNode temp = root;
		while(!st.isEmpty() || root != null) {
			if(root != null) {
				st.push(root);
				root = root.left;
			}else {
				root = st.pop();
				System.out.print(root.val + " ");
				root = root.right;
			}
		}
	}
	//iterative approach
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println("Iterative inorder traversal :: ");
		inorder(root);
		System.out.println("Iterative inorder traversal :: ");
		inOrder(root);
		System.out.println("Iterative inorder traversal -1 :: ");
		inorderTraversal(root);
	}

}
