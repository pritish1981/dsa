package dp.three;

/** Given N toys with their happiness and weight. Find maximum total happiness that can be kept in a bag with capacity W.
 *  Note: toys can't be divided.
 *
 */
public class ZeroOneKnapSack {
	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int weight[], int profit[], int N) {
		int i, j;
		int dp[][] = new int[N + 1][W + 1];
		// Build table dp[][] in bottom up manner
		for (i = 1; i <= N; i++) {
			for (j = 1; j <= W; j++) {
				// base condition
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				// calculate the maximum value when current items is not taken
				int notTaken = dp[i - 1][j];
				// calculate the maximum value when current items is taken
				int taken = Integer.MIN_VALUE;
				if (weight[i - 1] <= j) {
					taken = profit[i - 1] + dp[i - 1][j - weight[i - 1]];
				}
				// store the maximum value for the current state
				dp[i][j] = Math.max(notTaken, taken);
			}
		}

		return dp[N][W];
	}

	// Driver code
	public static void main(String args[]) {
		int profit[] = new int[] { 60, 100, 120 };
		int weight[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = profit.length;
		System.out.println(knapSack(W, weight, profit, n));
	}

}
