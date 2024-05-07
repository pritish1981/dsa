/**
 * 
 */
package dp.string;

/**
 * @author User
 *
 */
public class WildCardPatternMatchingExample {

	/**
	 * Bottom Up approach
	 */
	public static boolean bottomup_pattern(String s, String p) {
		int n = s.length(), m = p.length();
		if (s == null || p == null)
			return false;
		boolean dp[][] = new boolean[n + 1][m + 1];
		dp[0][0] = true;// since empty string matches with empty pattern
		for (int j = 1; j <= m; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		return dp[n][m];
		// Time Complexity: O(N*M), Space Complexity: O(N*M)
	}
	public static void main(String[] args) {
		String s = "aa", p = "*";
		System.out.println("Bottom-up approch::" + bottomup_pattern(s, p));
	}

}
