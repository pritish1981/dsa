/**
 * 
 */
package dp.one;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
 *
 */
public class WaysToDecode {

	public static int numDecodings(String A) {
		int mod = 1000000007;
		int n = A.length();
		if (A == null || n == 0)
			return 0;
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = A.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= n; i++) {
			int first = Integer.valueOf(A.substring(i - 1, i));
			int second = Integer.valueOf(A.substring(i - 2, i));

			if (first >= 1 && first <= 9) {
				dp[i] += dp[i - 1] % mod;
			}
			if (second >= 10 && second <= 26) {
				dp[i] += dp[i - 2] % mod;
			}

		}
		return dp[n] % mod;
	}

	public static void main(String[] args) {
		String A = "12";
		System.out.println("Ways to Decode :: " + numDecodings(A));
		/*
		 * Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
           The number of ways decoding "12" is 2.
		 * 
		 */

	}

}
