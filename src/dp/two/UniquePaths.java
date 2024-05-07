/**
 * 
 */
package dp.two;

/**
 * Given matrix of N * M, Find total no. of ways to reach from (0,0) to (N-1, M-1).
 *
 */
public class UniquePaths {

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = m; i >= 0; i--) {
			for (int j = n; j >= 0; j--) {
				if (i == m || j == n)
					dp[i][j] = 0;
				else if (i == m - 1 && j == n - 1)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		System.out.println("No of paths in 2D Matrix using bottom-up approach :: " + uniquePaths(3, 2));

	}

}
