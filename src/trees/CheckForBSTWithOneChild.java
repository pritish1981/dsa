/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class CheckForBSTWithOneChild {

	public String solve(int[] A) {
		int n = A.length;
		int l = Integer.MIN_VALUE;
		int r = Integer.MAX_VALUE;
		TreeNode root = new TreeNode(A[0]); 
		for(int i = 1;i<n;i++) {
			if(A[i] > root.val) {
				l = root.val;
			}else {
				r = root.val;
			}if(A[i] < l || A[i] > r) return "NO";
			root.val = A[i];
		}
		return "YES";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
