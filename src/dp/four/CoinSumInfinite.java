/**
 * 
 */
package dp.four;

import java.util.Arrays;

/**
 * Problem Description
You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE: Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).

Problem Constraints :
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000

Input Format
First argument is an integer array A representing the set.
Second argument is an integer B.

Output Format
Return an integer denoting the number of ways.

Example Input :
Input 1:

 A = [1, 2, 3]
 B = 4
Input 2:

 A = [10]
 B = 10

Example Output :
Output 1:  4
Output 2:  1

Example Explanation
Explanation 1:

 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3} 
Explanation 2:

 There is only 1 way to make sum 10.
 *
 */
public class CoinSumInfinite {

	public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int Mod = 1000000 + 7;
        int i, j, n = coins.length;
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (i = 0; i < n; i++) {
            for (j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
                dp[j] %= Mod;

            }
        }
        return dp[amount];
    }
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int amount = 4;
        System.out.println("No. of ways sum can be made:: " + coinChange(coins, amount) );
	}

}
