/**
 * 
 */
package dp.string;

/**
 * Given an integer array nums, return the length of the longest strictly increasing 
subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
 *
 */
public class LongestIncreasingSubsequence {

	static int lis(int[] A) {
		int n = A.length;
		if (A == null || A.length == 0)
			return 0;
		int[] dp = new int[n];
		int ans = 1;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i])
					max = Math.max(max, dp[j]);
			}
			dp[i] = max + 1;
			ans = Math.max(dp[i], ans);
		}
		return ans;
		// Time Complexity: O(N^2), Space Complexity: O(N)
	}

	public static void main(String[] args) {
		int nums[] = { 10, 3, 12, 7, 9, 11, 20, 17, 13, 6, 8 }; 
		System.out.println("Length of longest increasing subsequence is :: " + lis(nums));
	}

}
