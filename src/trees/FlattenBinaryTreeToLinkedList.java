/**
 * 
 */
package trees;

import java.util.Stack;

/**
 * @author Pritish
 *
 */
public class FlattenBinaryTreeToLinkedList {
	static TreeNode prev = null;
    //recursive approach -- reverse pre order traversal
	static void flattenR(TreeNode root) {
		if (root == null) return;
		flattenR(root.right);
		flattenR(root.left);
		
		root.right = prev;
		root.left = null;
		prev = root;
	}
	
	//iterative approach
	static void flattenI(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode curr = st.peek();
			st.pop();
			if(curr.right != null)
				st.push(curr.right);
			if(curr.left != null)
				st.push(curr.left);
			if(!st.isEmpty())
				curr.right = st.peek();
			curr.left = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		flattenI(root);
		while (root.right != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
		System.out.print(root.val);
	}

}


