/**
 * 
 */
package dp.two;

/**
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). 
   At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
   Now consider if some obstacles are added to the grids. 
   Return the total number unique paths from (1, 1) to (n, m).

   Note: An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
 *
 */
public class UniquePathsWithObstacles {

	public static int uniquePathsWithObstacles(int[][] A) {
		int[][] dp = new int[A.length][A[0].length];

		int N = dp.length - 1;
		int M = dp[0].length - 1;

		for (int i = N; i >= 0; i--) {
			for (int j = M; j >= 0; j--) {

				if (A[i][j] == 1) { // if obstacle means block
					dp[i][j] = 0;
				} else if (i == N && j == M) {
					dp[i][j] = 1; // if i am at N,M number of ways = 1 dont make any move
				} else if (i == N) {
					dp[i][j] = dp[i][j + 1]; // last row means can move only horizontal vertical moves are not valid
				} else if (j == M) {
					dp[i][j] = dp[i + 1][j];
				} else {
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
				}
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		int[][] grid  = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.print("Solution using Bottom-Up approach :: "+ uniquePathsWithObstacles(grid));
	     // Time Complexity: O(m*n) , Auxiliary Space: O(m*n)
	}

}
