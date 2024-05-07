/**
 * 
 */
package dp.string;

/**
 * Problem Description
Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.

Problem Constraints
1 <= length of(A) <= 10^3

Input Format
First and only integer is a string A.

Output Format
Return an integer denoting the length of longest palindromic subsequence.

Example Input
Input 1:  A = "bebeeed"
Input 2:  A = "aedsead"

Example Output
Output 1:  4
Output 2:  5
 *
 */
public class LongestPalindromicSubsequence {
	
	//bottom-up approach
	public static int lps(String S) {
		String R = new StringBuilder(S).reverse().toString();
		// dp[i][j] will store the length of the longest palindromic subsequence for the
		// substring starting at index i & ending at index j
		int dp[][] = new int[S.length() + 1][R.length() + 1];
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= R.length(); j++) {
				if (S.charAt(i - 1) == R.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[S.length()][R.length()];
	}
	//Time Complexity: O(N^2), Space Complexity: O(N^2)

	public static void main(String[] args) {
		String A = "GEEKSFORGEEKS";
		System.out.println("Longest palindromic subsequence of string A in tabulation approaoch is:: " + lps(A));
		/*Input: S = �GEEKSFORGEEKS�
          Output: 5
          Explanation: The longest palindromic subsequence we can get is of length 5. 
          There are more than 1 palindromic subsequences of length 5, for example: EEKEE, EESEE, EEFEE, �etc. */
		
	}

}
