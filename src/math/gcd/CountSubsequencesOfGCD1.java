/**
 * 
 */
package math.gcd;

/**
 * Given an array of N numbers, the task is to count the number of subsequences that have gcd equal to 1. 
 *Example: Input: a[] = {3, 4, 8, 16} ,Output: 7
The subsequences are:  
{3, 4}, {3, 8}, {3, 16}, {3, 4, 8},
{3, 4, 16}, {3, 8, 16}, {3, 4, 8, 16}
 */
public class CountSubsequencesOfGCD1 {

	/**
	 * Basically, the approach will be making a 2d matrix in which i coordinate will be the position of elements of the given array 
	 * and the j coordinate will be numbers from 0 to 100 ie. gcd can vary from 0 to 100 if array elements are not enough large.
	 * we will iterate on the given array and the 2d matrix will store information that till ith position that how many subsequences
	 * are there having gcd vary from 1 to 100. later on, we will add dp[i][1] to get all subsequences having gcd as 1.
	 */
	// gcd of two number
	static int gcd(int a, int b)
	{
	    if (b == 0)
	        return a;
	         
	    return gcd(b, a % b);
	}
	 
	// This function will return total
	// subsequences
	static long countSubsequences(int arr[],int n)
	{
		// Declare a dp 2d array
		long dp[][] = new long[n][101];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 101; j++) {
				dp[i][j] = 0;
			}
		}
		// Iterate i from 0 to n - 1
		for (int i = 0; i < n; i++) {
			dp[i][arr[i]] = 1;
			// Iterate j from i - 1 to 0
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					// Iterate k from 0 to 100
					for (int k = 0; k <= 100; k++) {
						// Find gcd of two number
						int GCD = gcd(arr[i], k);
						// dp[i][GCD] is summation of
						// dp[i][GCD] and dp[j][k]
						dp[i][GCD] = dp[i][GCD] + dp[j][k];
					}
				}
			}
		}
		// Add all elements of dp[i][1]
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + dp[i][1]);
		}
		// Return sum
		return sum;
	}
	
	public static void main(String[] args) {
		int a[] = { 3, 4, 8, 16 };
	    int n = a.length;
	    // Function Call
	    System.out.println(countSubsequences(a, n));

	}

}
