/**
 * 
 */
package dp.three;

import java.util.Arrays;

/**
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
Problem Constraints :
1 <= N <= 10^3
1 <= C <= 10^3
1 <= A[i], B[i] <= 10^3
 *
 */
public class ZeroOneKnapSackI {

	static int maxn = 1009;
	static int[][] dp = new int[maxn][maxn];

	public static int knapsack(int[] A, int[] B, int C) {
		for (int[] row : dp)
			Arrays.fill(row, 0);
		int n = A.length;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= C; j++) {
				dp[i][j] = dp[i - 1][j];
				if (B[i - 1] <= j)
					dp[i][j] = Math.max(dp[i][j], A[i - 1] + dp[i - 1][j - B[i - 1]]);
			}
		}
		return dp[n][C];
	}

	public static void main(String[] args) {
		int[] A = { 60, 100, 120 };
		int[] B = { 10, 20, 30 };
		int C = 50;
		System.out.println(knapsack(A, B, C));

	}

}
