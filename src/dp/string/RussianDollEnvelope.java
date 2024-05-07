/**
 * 
 */
package dp.string;

import java.util.Arrays;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * Note: You cannot rotate an envelope.
 *
 * Example 1:
 *
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * Example 2:
 *
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= envelopes.length <= 105
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 105
 */

public class RussianDollEnvelope {
	//sort on the basis of height
	//apply LIS on width(h1 != h2)
	
	public static int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		if (n == 0)
			return n;
		// sort enevelopes in increasing order
		Arrays.sort(envelopes, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
		int dp[] = new int[n];
		dp[0] = 1;
		int ans = 1;
		// apply LIS on width
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
	// Time Complexity: O(n^2), Space Complexity: O(n)

	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		System.out.println("The maximum number of envelopes you can Russian doll is:: "+maxEnvelopes(envelopes));
		
	}

}
