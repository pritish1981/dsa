/**
 * 
 */
package dp.string;

/**
 * Problem Description
Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints
1 <= length(A), length(B) <= 104

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format
Return 1 if the patterns match else return 0.

Example Input
Input 1:

 A = "aaa"
 B = "a*"
Input 2:

 A = "acz"
 B = "a?a"


Example Output
Output 1: 1
Output 2: 0


Example Explanation
Explanation 1:

 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:

 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.

 *
 */
public class WildCardPatternMatching {
	
	//Top-down or Memoization approach
	public static boolean isMatchMemo(String s, String p) {
		int n = s.length();
		int m = p.length();
		if (m == 0 && n != 0)
			return false;

		boolean[][] dp = new boolean[n][m];
		return match(s, p, n - 1, m - 1, dp);
	}

	public static boolean match(String s, String p, int n, int m, boolean[][] dp) {
		// Base Case
		// if n and m both are 0 i.e strings are matching
		if (n < 0 && m < 0)
			return true;
		// if n has some char but m is empty
		if (n >= 0 && m < 0)
			return false;
		// if m has some char but n is empty
		if (n < 0 && m >= 0) {
			// String p contains all '*' till j'th index
			for (int i = 0; i <= m; i++)
				if (p.charAt(i) != '*')
					return false;
			return true;
		}

		if (dp[n][m])
			return dp[n][m];

		if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '?')
			return dp[n][m] = match(s, p, n - 1, m - 1, dp);
		else if (p.charAt(m) == '*')
			return dp[n][m] = match(s, p, n - 1, m, dp) || match(s, p, n, m - 1, dp);
		else {// if both char are not equal
			return false;
		}

	}
	
	//Tabulation or bottum-up approach
	public static boolean isMatchTab(String s, String p) {
		if (s == null || p == null)
			return false;

		int N = s.length(), M = p.length();
		boolean[][] dp = new boolean[N + 1][M + 1];
		// dp[0][0] = true since Empty string matches empty pattern
		dp[0][0] = true;
		// 2.dp[0][i] = false, since empty pattern can-not match non-empty string
		// 3.dp[j][0] for any * will match empty string
		for (int j = 1; j <= M; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[j][0] = dp[j - 1][0];
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
					dp[i][j] = dp[i - 1][j - 1];
				else if (p.charAt(j - 1) == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

			}
		}
		return dp[N][M];
		// Time Complexity: O(N*M), Space Complexity: O(N*M)
	}
	

	public static void main(String[] args) {
		String S = "xbbzzc", P = "x*z*";
		String s = "aa", p = "*";
		System.out.println("Memoization  approch::" + isMatchMemo(s, p));
		System.out.println("Tabulation  approch::" + isMatchTab(s, p));

	}

}
