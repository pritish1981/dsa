/**
 * 
 */
package dp.one;

/**
 * Given a positive integer A, write a program to find the Ath Fibonacci number.
 *
 */
public class FindNthFibonaciNumber {
    //bottom up approach
	static int fibonnaci(int n) {
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
		//T.C: O(N), S.C: O(N)
	}
	
	//optimized space
	static int getFibonaci(int n) {
		if (n <= 1) return 1;
		int a =0, b = 1, c= 0;
		for(int i=2;i<=n;i++) {
			c =a+b;
			a = b;
			b =c;
			
		}
		return b;
		//T.C: O(N), S.C: O(1)
	}
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Nth fibonacci number in bottom up approach is :: "+ fibonnaci(n));
		System.out.println("Nth fibonacci number in optimized space is :: "+ getFibonaci(n));

	}

}
