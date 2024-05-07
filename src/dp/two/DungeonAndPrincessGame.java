/**
 * 
 */
package dp.two;

/**
 * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Return the knight's minimum initial health so that he can rescue the princess.
 *
 */
public class DungeonAndPrincessGame {
	
	// bottom-up Approach- Tabulated
	public static int calculateMinHealth(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int dp[][] = new int[n][m];
		// base case
		if (A[n - 1][m - 1] > 0) {
			dp[n - 1][m - 1] = 1;
		} else {
			dp[n - 1][m - 1] = Math.abs(A[n - 1][m - 1]) + 1;
		}

		// Fill the last col as a base to fill entire table
		for (int i = n - 2; i >= 0; i--) {
			dp[i][m - 1] = Math.max(1, dp[i + 1][m - 1] - A[i][m - 1]);
		}

		// Fill the last row as a base to fill entire table
		for (int j = m - 2; j >= 0; j--) {
			dp[n - 1][j] = Math.max(1, dp[n - 1][j + 1] - A[n - 1][j]);
		}

		// Fill rest of the table in bottom-up fashion
		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {

				int minHealth = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j]);
				dp[i][j] = minHealth;

			}
		}
		return dp[0][0];
	}
	

	public static void main(String[] args) {
		int[][] A = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println("Solved by bottom up approach :: " + calculateMinHealth(A) );
	}

}
