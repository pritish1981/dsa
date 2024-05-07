/**
 * 
 */
package dp.four;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 *
 */
public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println("Fewest no ofcoins needed using sol-2::" + coinChange(coins, amount));
	}
}
