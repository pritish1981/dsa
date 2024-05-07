/**
 * 
 */
package dp.string;

import java.util.Arrays;

/**
 * Given a knapsack weight W and a set of n items with certain value val,i and weight wt,i,
 * we need to calculate the maximum amount that could make up this quantity exactly.here we are allowed to use unlimited number of instances of an item.
 *
 */
public class UnboundedKnapsack {

	
	public static int uboundedKnpsack(int N, int W, int[] weight, int[] profit) {
		// dp[i] is going to store maximum value with knapsack capacity i.
		int dp[] = new int[W + 1];
		Arrays.fill(dp, 0);
		// build dp[][] in bottom up manner
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j < N; j++) {
				if (weight[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - weight[j]] + profit[j]);
				}
			}
		}
		return dp[W];

	}
		
	public static void main(String[] args) {
		int W = 100;
        int profit[] = {10, 30, 20};
        int weight[] = {5, 10, 15};
        int N = profit.length;
        System.out.println("Max profit unbounded-knapsack can hold :: " + uboundedKnpsack(N,W,weight,profit) );

	}

}
