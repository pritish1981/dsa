/**
 * 
 */
package dp.string;

import java.util.Arrays;

/**
 *Problem Description
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Problem Constraints
1 <= length(A), length(B) <= 450

Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format
Return an integer, representing the minimum number of steps required.

Example Input
Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman

Example Output
Output 1: 1
Output 2: 2


Example Explanation
Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
 *
 */
public class EditDistance {
	// top-down approach or memoization
	public static int minDistanceTD(String A, String B) {
		int n = A.length();
		int m = B.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int[] d : dp)
			Arrays.fill(d, -1);
		return minDistanceMemo(A, B, n, m, dp);
	}

	public static int minDistanceMemo(String A, String B, int n, int m, int[][] dp) {
		if (n == 0)
			return m;
		if (m == 0)
			return n;
		if (dp[n][m] != -1) {
			return dp[n][m];
		}
		// if last char is equal in both the strings
		if (A.charAt(n - 1) == B.charAt(m - 1)) {
			dp[n][m] = minDistanceMemo(A, B, n - 1, m - 1, dp);
		} else {// if last char is not equal
			int insert = minDistanceMemo(A, B, n, m - 1, dp);
			int delete = minDistanceMemo(A, B, n - 1, m, dp);
			int replace = minDistanceMemo(A, B, n - 1, m - 1, dp);
			dp[n][m] = 1 + Math.min(replace, Math.min(insert, delete));
		}
		return dp[n][m];
	}
	// T.C: O(N*M), S.C: O(N*M)

	// Solution 2: Bottom-up approach or tabulation
	public static int minDistance(String A, String B) {
		int n = A.length();
		int m = B.length();
		int[][] dp = new int[n + 1][m + 1];
		// intialize the array
		for (int i = 0; i <= n; i++)
			dp[i][0] = i;
		for (int j = 0; j <= m; j++)
			dp[0][j] = j;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					int insert = dp[i][j-1], delete = dp[i-1][j], replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
				}
			}
		}
		return dp[n][m];
		// T.C: O(N*M), S.C: O(N*M)
	}

	public static void main(String[] args) {
		String A = "abcd", B = "abe";
		System.out.println("Minimum number of steps required to convert A to B using tabulation :: " + minDistance(A, B));
		System.out.println("Minimum number of steps required to convert A to B using memoization :: " + minDistanceTD(A, B));

	}

}
