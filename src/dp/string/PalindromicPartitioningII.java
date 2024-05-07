/**
 * 
 */
package dp.string;

/**
 * Problem Description
Given a string A, partition A such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of A.

Problem Constraints
1 <= length(A) <= 501

Input Format
The first and the only argument contains the string A.

Output Format
Return an integer, representing the minimum cuts needed.

Example Input
Input 1:  A = "aba"
Input 2:  A = "aab"


Example Output
Output 1: 0
Output 2: 1


Example Explanation
Explanation 1:  "aba" is already a palindrome, so no cuts are needed.
Explanation 2:  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

https://www.youtube.com/watch?v=Oi6a4O00n4U&t=3s
 *
 */
public class PalindromicPartitioningII {

	static int palindromicPartition(String s) {
		int n = s.length();
		int dp[][] = new int[n][n];
		for (int gap = 1; gap < n; gap++) {
			for (int row = 0, col = gap; row < n - gap; row++, col++) {
				if (isPal(s, row, col)) {
					dp[row][col] = 0;
				} else {
					dp[row][col] = Integer.MAX_VALUE;
					for (int k = row; k < col; k++) {
						dp[row][col] = Math.min(dp[row][col], 1 + dp[row][k] + dp[k + 1][col]);
					}
				}
			}
		}
		return dp[0][n - 1]; // return top-right corner 
	}

	static boolean isPal(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "babc";
		System.out.println("Minimum cut needed for palindromic partition is :: " +palindromicPartition(s));

	}

}
