/**
 * 
 */
package dp.one;

/**
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 *
 */
public class MInimumNoOfPerfectSquares {
	
	//Using Memoization approach
	public static int minSquares(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; i - j * j >= 0; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]);
			}
			dp[i] += 1;
		}
		int ans = dp[n];
		return ans;
		//Time Complexity: O(n*sqrtn)
		//Space Complexity: O(n)
	}
		
        
	
	public static void main(String[] args) {
		int A = 6;
		System.out.println("Minimum perfect sqaures using memoization ==>" + minSquares(A));
		/* Input: 6, Output: 3
		 * Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
           Minimum count of numbers, sum of whose squares is 6 is 3. 
		 * 
		 * 
		 */
	}

}
