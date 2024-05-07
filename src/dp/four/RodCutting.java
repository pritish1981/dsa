/**
 * 
 */
package dp.four;

/**
 * Problem Description
Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.

Problem Constraints : 
1 <= N <= 1000
0 <= A[i] <= 10^6

Input Format : 
First and only argument is an integer array A of size N.
Output Format
Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.

Example Input:
Input 1:  A = [3, 4, 1, 6, 2]
Input 2:  A = [1, 5, 2, 5, 6]

Example Output:
Output 1:  15
Output 2:  11
 *
 */
public class RodCutting {

	public static int cutRod(int A[]) {
		int n = A.length;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = A[i - 1];
		}
		for (int i = 2; i <= n; i++) {
			int left = 0, right = i;
			while (left <= right) {
				dp[i] = Math.max(dp[i], dp[left] + dp[right]);
				left++;
				right--;
			}
		}
		return dp[n];
	}
	
	public static int cuttingRod(int A[]) {
		int n = A.length;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		// Build the table dp[] in bottom up manner and return the last entry from the
		// table
		for (int i = 1; i <= n; i++) {
			int maxVal = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				maxVal = Math.max(maxVal, A[j] + dp[i - j - 1]);
				dp[i] = maxVal;
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is " + cutRod(price));
        System.out.println("Maximum Obtainable Value is sol-2 ::  " + cuttingRod(price));
	}

}
