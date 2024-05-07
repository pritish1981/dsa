/**
 * 
 */
package dp.four;

/**
 * Problem Description:
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
NOTE: You cannot break an item, either pick the complete item, or don�t pick it (0-1 property).

Problem Constraints:
1 <= N <= 500
1 <= C, B[i] <= 106
1 <= A[i] <= 50

Input Format :
First argument is an integer array A of size N denoting the values on N items.
Second argument is an integer array B of size N denoting the weights on N items.
Third argument is an integer C denoting the knapsack capacity.

Output Format:
Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

Example Input :
Input 1:

 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10
 
 Example Output :
 Output 1:  22
 Output 2:  0
 *
 *
 */
public class ZeroOneKnapSackII {

	public static int solve(int[] val, int[] wt, int capacity) {
		int n = val.length;
		int maxVal = 50 * n;
		int dp[] = new int[maxVal + 1];
		//initialize 1st row to infinity
		for (int i = 0; i < maxVal + 1; i++) {
			dp[i] = 1000000000;
		}
		//set 1st column to 0
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = maxVal; j >= val[i]; j--) {
				dp[j] = Math.min(dp[j], wt[i] + dp[j - val[i]]);
			}
		}
		int ans = 0;
		for (int j = maxVal; j >= 0; j--) {
			if (dp[j] <= capacity) {
				ans = j;
				break;
			}
		}
		return ans;

	}
	public static void main(String[] args) {
		int[] A = {6, 10, 12};
		int[] B = {10, 20, 30};
		int C = 50;
		System.out.println(solve(A,B,C));

	}

}
