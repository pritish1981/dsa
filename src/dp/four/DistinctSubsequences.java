/**
 * 
 */
package dp.four;

/**
 * Problem Description
Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Problem Constraints
1 <= length(A), length(B) <= 700

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format
Return an integer representing the answer as described in the problem statement.

Example Input
Input 1:

 A = "abc"
 B = "abc"
Input 2:

 A = "rabbbit" 
 B = "rabbit" 


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 Both the strings are equal.
Explanation 2:

 These are the possible removals of characters:
    => A = "ra_bbit" 
    => A = "rab_bit" 
    => A = "rabb_it"

 Note: "_" marks the removed character.
 
 
Solution Approach:

1.we will build an array dp where dp[i+1][j+1] means that S[0..j] contains T[0..i] that many times as distinct subsequences.
Therefore the result will be dp[T.length()][S.length()].
2.we can build this array rows-by-rows:
3.the first row must be filled with 1. That's because the empty string is a subsequence of any string but only 1 time. So dp[0][j] = 1 for every j.
  So with this we not only make our lives easier, but we also return correct value if T is an empty string.
4.the first column of every rows except the first must be 0. This is because an empty string cannot contain a non-empty string as a substring -- 
  the very first item of the array: dp[0][0] = 1, because an empty string contains the empty string 1 time.
So the matrix looks like this:

  S 0123....j
T +----------+
  |1111111111|
0 |0         |
1 |0         |
2 |0         |
. |0         |
. |0         |
i |0         |
From here we can easily fill the whole grid: for each (x, y), we check if S[x] == T[y] we add the previous item and the previous item in the previous row, 
otherwise we copy the previous item in the same row. The reason is simple:

if the current character in S doesn't equal to current character T, then we have the same number of distinct subsequences as we had without the new character.
if the current character in S equal to the current character T, then the distinct number of subsequences: the number we had before plus the distinct number of 
subsequences we had with less longer T and less longer S.

An example:
S: [acdabefbc] and T: [ab]

first we check with a:

           *  *
      S = [acdabefbc]
dp[1] =   [0111222222]

then we check with ab:

               *  * ]
      S = [acdabefbc]
dp[1] = [0111222222]
dp[2] = [0000022244]
And the result is 4, as the distinct subsequences are:

      S = [a   b    ]
      S = [a      b ]
      S = [   ab    ]
      S = [   a   b ]
 *
 */
public class DistinctSubsequences {

	public static int distinctSubsequence(String A, String B) {
		int dp[][] = new int[B.length() + 1][A.length() + 1];
		// filling the first row: with 1s
		for (int j = 0; j < A.length(); j++) {
			dp[0][j] = 1;
		}
		// the first column is 0 by default in every other rows but the first, which we
		// need.
		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				if (B.charAt(i) == A.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
				} else {
					dp[i + 1][j + 1] = dp[i + 1][j];
				}
			}
		}
		return dp[B.length()][A.length()];
	}

	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(distinctSubsequence(S, T));

	}

}
