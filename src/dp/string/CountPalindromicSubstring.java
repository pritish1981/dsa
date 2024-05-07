/**
 * 
 */
package dp.string;

/**
 * Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 */
public class CountPalindromicSubstring {

	// Time Complexity: O(N^2), Space Complexity: O(1)
	public static int countSubstrings(String s) {
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		int count = 0;
		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
				}
				if (dp[i][j])
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "abc";
		System.out.println("Palnidromic substring count is :: " + countSubstrings(s));
	}

}
