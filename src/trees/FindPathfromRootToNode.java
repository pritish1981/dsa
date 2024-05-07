/**
 * 
 */
package trees;

import java.util.ArrayList;

/**
 * @author User
 *
 */
public class FindPathfromRootToNode {
	static TreeNode root;

	static boolean getPath(TreeNode root, ArrayList<Integer> ans, int k) {
		if(root == null) return false;
		ans.add(root.val);
		if(root.val == k) return true;
		if(getPath(root.left, ans, k) || getPath(root.right, ans, k))
			return true;
		// If required node does not lie either in the left or right subtree of the current node
        // Thus, remove current node's value from 'ans'and then return false 
		ans.remove(ans.size()-1);
		return false;
	}
	public static void main(String[] args) {
		root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(15);
		root.left.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(17);
		
		ArrayList<Integer> ans = new ArrayList<>();
		boolean res;
		res = getPath(root, ans, 15);
		System.out.println("The path from root to given node is::");
		for(int x: ans)
			System.out.print(x + ",");

	}

}
