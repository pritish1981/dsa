/**
 * 
 */
package dp.string;

/**
 * Problem Description
Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.

Problem Constraints
1 <= Length of A, B <= 1005

Input Format
First argument is a string A.
Second argument is a string B.

Output Format
Return an integer denoting the length of the longest common subsequence.

Example Input
Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
Input 2:

 A = "aaaaaa"
 B = "ababab"


Example Output
Output 1: 5
Output 2: 3

Example Explanation
Explanation 1:

 The longest common subsequence is "bbcgf", which has a length of 5.
Explanation 2:

 The longest common subsequence is "aaa", which has a length of 3.

[i-1][j-1], [i-1][j]
[i],[j-1],  [i,j]
 *
 */
public class LongestCommonSubsequence {

	public static int lcs(String A, String B) {
		int n = A.length(), m = B.length();
		int dp[][] = new int[n + 1][m + 1];

		// initialize row 0 ->0 col 0 -> 0
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		// fill the rest of the table using bottom up manner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
		// Time Complexity: O(N*M), Space Complexity: O(N*M)
	}
	
	
	//print longest common subsequence
	public static void printLCS(String A, String B) {
		int n = A.length(), m = B.length();
		int dp[][] = new int[n + 1][m + 1];

		// initialize row 0 ->0 col 0 -> 0
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = 0;
			}
		}
		// fill the rest of the table using bottom up manner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// print lcs
		int len = dp[n][m];
		int i = n;
		int j = m;
		int index = len - 1;
		String str = "";
		for (int k = 1; k <= len; k++) {
			str += "$";// dummy string
		}
		StringBuilder str1 = new StringBuilder(A);
		StringBuilder str2 = new StringBuilder(str);
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == B.charAt(j - 1)) {
				str2.setCharAt(index, str1.charAt(i - 1));
				index--;
				i--;
				j--;
			} else if (str1.charAt(i - 1) > B.charAt(j - 1)) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(str2);
	}
	//Time Complexity: O(N*M), Space Complexity: O(N*M)
	
	public static void main(String[] args) {
		String s1 = "abcde", s2 = "bdgek";
		System.out.println("Length of longest common subsequence is :: " + lcs(s1, s2));
		System.out.println("<========>");
		System.out.print("The Longest Common Subsequence is :: ");
		printLCS(s1, s2);

	}

}
