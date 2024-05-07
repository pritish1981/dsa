/**
 * 
 */
package dp.three;

/**
 * Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i].
The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.
Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?

Problem Constraints:
1 <= N <= 700
1 <= A[i] <= 1000
1 <= B[i] <= 1000
1 <= C[i],D <= 1000

Input Format:
First argument of input is an integer array A - candies
Second argument of input is an integer array B - sweetness
Third argument of input is an integer array C - nibbles
Fourth argument of input is an integer D - nibbles capacity

Output Format:
Return a single integer denoting maximum sweetness of the candies that he can buy

Example Input :
Input 1:

 A = [1, 2, 3]
 B = [2, 2, 10]
 C = [2, 3, 9]
 D = 8
Input 2:

 A = [2]
 B = [5]
 C = [10]
 D = 99

Example Output
Output 1:  10
Output 2:  90
 *
 */
public class BuyingCandies {

	public static int solve(int[] A, int[] B, int[] C, int D) {
		int n = A.length;
		int[] dp = new int[D + 1];

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= D; ++j) {
				if (j - C[i - 1] >= 0) {
					dp[j] = Math.max(dp[j], A[i - 1] * B[i - 1] + dp[j - C[i - 1]]);
				}
			}
		}
		return dp[D];
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		int[] B = { 2, 2, 10 };
		int[] C = { 2, 3, 9 };
		int D = 8;
		System.out.println(solve(A, B, C, D));

	}

}
