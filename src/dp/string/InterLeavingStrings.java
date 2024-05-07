/**
 * 
 */
package dp.string;

/**
 * Problem Description
Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. C is said to be an interleaving A and B, 
if it contains all and only characters of A and B and order of all characters in individual strings is preserved. 

Example: 

Input: strings: "XXXXZY", "XXY", "XXZ"

Output: XXXXZY is interleaved of XXY and XXZ

The string XXXXZY can be made by 
interleaving XXY and XXZ
String C:    XXXXZY
String A:    XX Y
String B:  XX  Z

Input: strings: "XXY", "YX", "X"

Output: XXY is not interleaved of YX and X

XXY cannot be formed by interleaving YX and X.
The strings that can be formed are YXX and XYX

Problem Constraints
1 <= length(A), length(B) <= 100
1 <= length(C) <= 200

Input Format:
The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.

Output Format:
Return 1 if string C is formed by interleaving of A and B else 0.

 *
 */
public class InterLeavingStrings {
    //Solution 1: Recursion
	public static boolean isInterleavedRec(String A, String B, String C) {
		// Base Case: If all strings are empty
		if (A.isEmpty() && B.isEmpty() && C.isEmpty()) {
			return true;
		}

		// If C is empty and any of the two strings is not empty
		if (C.isEmpty()) {
			return false;
		}

		// If any of the above mentioned two possibilities is true,then return true,otherwise false
		return (C.charAt(0) == A.charAt(0) && isInterleavedRec(A.substring(1), B, C.substring(1)))
				|| (C.charAt(0) == B.charAt(0) && isInterleavedRec(A, B.substring(1), C.substring(1)));

		// Time Complexity: O(2^N), Space Complexity: O(1)
	}
	
	//Dynamic Programming Approach: Solution 2
	
	public static boolean isInterleaved(String A, String B, String C) {
		int n = A.length(), m = B.length();
		// Let us create a 2D table to store solutions of subproblems. C[i][j] will be
		// true if C[0..i+j-1] is an interleaving of A[0..i-1] and B[0..j-1].
		boolean dp[][] = new boolean[n + 1][m + 1];
		// dp is default initialized by false
		// C can be an interleaving of A and B only if the sum of lengths of A and B is
		// equal to length of C
		if ((n + m) != C.length()) {
			return false;
		}
		// process all characters of A & B
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				// two empty strings have an empty strings as interleaving
				if (i == 0 && j == 0)
					dp[i][j] = true;
				// A is empty
				else if (i == 0) {
					if (B.charAt(j - 1) == C.charAt(j - 1))
						dp[i][j] = dp[i][j - 1];
				}
				// B is empty
				else if (j == 0) {
					if (A.charAt(i - 1) == C.charAt(i - 1))
						dp[i][j] = dp[i - 1][j];
				}
				// Current character of C matches with current character of A, but doesn't match
				// with current character of B
				else if (C.charAt(i + j - 1) == A.charAt(i - 1) && C.charAt(i + j - 1) != B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j];
				}
				// Current character of C matches with current character of B, but doesn't match
				// with current character of A
				else if (C.charAt(i + j - 1) == B.charAt(j - 1) && C.charAt(i + j - 1) != A.charAt(i - 1)) {
					dp[i][j] = dp[i][j - 1];
				}
				// Current character of C matches with current character of both A & B
				else if (C.charAt(i + j - 1) == A.charAt(i - 1) && C.charAt(i + j - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		return dp[n][m];
		// Time Complexity: O(N * M), Space Complexity(O(N * M)
	}
	
	public static int isInterleave(String A, String B, String C) {
		if(isInterleaved(A,B,C) == true) return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		String A = "XXY", B = "XXZ", C = "XXXXZY";
		System.out.println("Recursion solution:: "+isInterleavedRec(A, B, C));
		System.out.println("Dynamic programming solution::" + isInterleave(A,B,C) );

	}

}
