/**
 * 
 */
package dp.string;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
Example:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
 *
 */
public class WildCardMatchingMemoization {

	public static boolean isMatch(String s, String p) {
		int i = s.length();
		int j = p.length();
		if (j == 0 && i != 0)
			return false;

		boolean[][] dp = new boolean[i][j];
		return match(s, p, i - 1, j - 1, dp);
	}

	public static boolean match(String s, String p, int i, int j, boolean[][] dp) {
		if (i < 0 && j < 0)
			return true;

		if (i < 0) {
			// String p contains all '*' till j'th index
			for (int k = 0; k <= j; k++)
				if (p.charAt(k) != '*')
					return false;

			return true;
		}

		if (i < 0 || j < 0) {
			return false;
		}

		if (dp[i][j])
			return dp[i][j];

		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
			dp[i][j] = match(s, p, i - 1, j - 1, dp);
		else if (p.charAt(j) == '*')
			dp[i][j] = match(s, p, i - 1, j, dp) | match(s, p, i, j - 1, dp);

		return dp[i][j];

	}

	public static void main(String[] args) {
		String s = "aa", p = "*";
		System.out.println("Memoization  approch::" + isMatch(s, p));

	}

}
