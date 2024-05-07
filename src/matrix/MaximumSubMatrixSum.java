/**
 * 
 */
package matrix;

/**
 * Given a matrix mat[][] whose elements are sorted both row-wise and column-wise. 
 * The task is to find the maximum sum of any sub-matrix from the given matrix mat[][]
 * 
 * DP[i][j] = DP[i+1][j] + DP[i][j+1] – DP[i+1][j+1]
 */
public class MaximumSubMatrixSum {

	public static int maxSubMatSum(int[][] mat) {
		int n = mat.length, m = mat[0].length;
		int i,j;
		//dp matrix to store the result of each iteration
		int[][] dp = new int[n][m];
		//base case: largest element in the matrix
		dp[n-1][m-1] = mat[n-1][m-1];
		//to store the final result
		int res = dp[n-1][m-1];
		// Find the max sub-matrix sum for last row
		for(i = m-2;i>=0;i--) {
			dp[n-1][i] = mat[n-1][i] + dp[n-1][i+1];
			res = Math.max(res, dp[n-1][i]);
		}
		// Find the max sub-matrix sum for last column
		for(i = n-2;i>=0;i--) {
			dp[i][m-1] = mat[i][m-1] + dp[i+1][m-1];
			res = Math.max(res, dp[i][m-1]);
		}
		//build dp[][] from bottom to top row
		for(i=n-2;i>=0;i--) {
			for(j=m-2;j>=0;j--) {
				//update sum at each cell of dp[][]
				dp[i][j] = mat[i][j] + dp[i+1][j] + dp[i][j+1] - dp[i+1][j+1];
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		// Given matrix mat[][]
	    int [][]mat= {{ -6, -4, -1 },
	                  { -3, 2, 4 },
	                  { 2, 5, 8 } };
	 
	    // Function Call
	    System.out.print(maxSubMatSum(mat));

	}

}
