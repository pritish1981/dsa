/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */

public class SearchInBST {

	//recursive approach
	public TreeNode search(TreeNode root, int k) {
		if(root == null || root.val == k)
			return root;
		if(root.val < k) {
			return search(root.right, k);
		}
		return search(root.left, k);
	}
	
	//iterative approach
	public int solve(TreeNode root, int key) {
	       TreeNode temp = root;
	       while(temp != null){
	           if(temp.val == key) return 1;
	           else if(key < temp.val){
	               temp = temp.left;
	           }else{
	               temp = temp.right;
	           }
	       }
	       return 0;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
