/**
 * 
 */
package trees;

import java.util.ArrayList;

/**
 * @author Pritish
 *
 */
public class MorrisInorderTraversal {
	static TreeNode root;

	public static ArrayList<Integer> morrisTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.val);
				curr = curr.right;
			}else {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right != curr) {
					temp = temp.right;
				}
				if(temp.right == null) { // create connection
					temp.right = curr;
					curr = curr.left;
				}else if(temp.right == curr) { // break the connection
					temp.right = null;
					ans.add(curr.val);
					curr = curr.right;
				}
			}
		}
		return ans;
	}
	//T.C: O(n), S.C: O(1)
	public static void main(String[] args) {
		/* Constructed binary tree is
        1
      /   \
     2      3
   /   \
  4     5
 */
		MorrisInorderTraversal tree = new MorrisInorderTraversal();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		tree.morrisTraversal(tree.root);
		System.out.println(tree.morrisTraversal(tree.root));

	}

}
