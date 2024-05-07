/**
 * 
 */
package dp.four;

import java.util.HashMap;

/**
 * Problem Description
Given a strictly increasing array A of positive integers forming a sequence.

A sequence X1, X2, X3, ..., XN is fibonacci like if


N > =3
Xi + Xi+1 = Xi+2 for all i+2 <= N
Find and return the length of the longest Fibonacci-like subsequence of A.

If one does not exist, return 0.

NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.

Problem Constraints
3 <= length of the array <= 1000

1 <= A[i] <= 10^9


Input Format
The only argument given is the integer array A.

Output Format
Return the length of the longest Fibonacci-like subsequence of A.
If one does not exist, return 0.

Example Input:  A = [1, 2, 3, 4, 5, 6, 7, 8]

Example Output : 5
Explanation :

 The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
 *
 */
public class LengthOfLongestFibbonaciSubsequence {

	public static int solve(int[] A) {
		int n = A.length;
		int ans = 0;
		int[][] dp = new int[1000][1000];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++)
			hm.put(A[i], i);
		// dp[i][j]--> this is length of longest fibonacci seq ending at j, i where(j <
		// i && a[j] < a[i] && search for (a[i] - a[j])
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int a3 = A[i];
				int a2 = A[j];
				// a1+a2 = a3 fibbonaci
				int a1 = a3 - a2;
				if (a1 < a2 && hm.containsKey(a1)) {
					int k = hm.get(a1);
					dp[i][j] = dp[j][k] + 1;
					ans = Math.max(ans, dp[i][j] + 2);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(solve(A));

	}

}
