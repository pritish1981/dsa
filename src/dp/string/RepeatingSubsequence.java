/**
 * 
 */
package dp.string;

/**
 * Problem Description
Given a string A, find if there is any subsequence that repeats itself.

A subsequence of a string is defined as a sequence of characters generated by deleting some characters in the string without changing the order of the remaining characters.

NOTE:
1. Subsequence length should be greater than or equal to 2.
2. The repeating subsequence should be disjoint that is in both the sequence no character in the same order and position should be taken from the same index of the original string.

Problem Constraints
1 <= length(A) <= 100

Input Format
The first and the only argument of input contains a string A.

Output Format
Return an integer, 1 if there is any subsequence which repeat itself else return 0.

Example Input
Input 1: A = "abab"
Input 2: A = "abba"


Example Output
Output 1: 1
Output 2: 0

Example Explanation
Explanation 1: "ab" is repeated.
Explanation 2: There is no repeating subsequence.
 *
 */
public class RepeatingSubsequence {

	public static int anytwo(String A) {
		int n = A.length();
		int dp[][] = new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}
				else if (A.charAt(i - 1) == A.charAt(j - 1) && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		if (dp[n][n] >= 2) {
			return 1;
		} else {
			return 0;
		}
	}
	//Time Complexity: O(N^2), Space Complexity: O(N^2)

	public static void main(String[] args) {
		String A = "abab";
		System.out.println("Repating subsequence in the given string is exists:: " + anytwo(A));

	}

}
