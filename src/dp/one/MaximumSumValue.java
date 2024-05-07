/**
 * 
 */
package dp.one;

/**
 * You are given an array A of N integers and three integers B, C, and D.
You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.

Solution:
/**
	 * An efficient solution is to precompute values and stores them using extra space. 
	 * The first key observation is i ≤ j ≤ k, so x*a[i] will always be the left maximum, and z*a[k] will always be the right maximum.
	 * Create a left array where we store the left maximums for every element. 
	 * Create a right array where we store the right maximums for every element.
	 * Then for every element, calculate the maximum value of the function possible. 
	 * For any index ind, the maximum at that position will always be (left[ind] + j * a[ind] + right[ind]),
	 * find the maximum of this value for every element in the array and that will be your answer.
	 */

public class MaximumSumValue {

	public static int maximizeExpr(int A[], int B, int C, int D) {
// Traverse the whole array and compute left maximum for every index.
		int n = A.length;
		int L[] = new int[n];
		L[0] = B * A[0];
		for (int i = 1; i < n; i++)
			L[i] = Math.max(L[i - 1], B * A[i]);

// Compute right maximum for every index.
		int R[] = new int[n];
		R[n - 1] = D * A[n - 1];
		for (int i = n - 2; i >= 0; i--)
			R[i] = Math.max(R[i + 1], D * A[i]);

// Traverse through the whole array to maximize the required expression.
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			ans = Math.max(ans, L[i] + R[i] + C * A[i]);

		return ans;
	}

	public static void main(String[] args) {
		int A[] = { 1, 5, -3, 4, -2 };
		int n = A.length;
		int B = 2, C = 1, D = -1;
		System.out.println(maximizeExpr(A, B, C, D));
		
		/*  output: 18
		 * If you choose i = 2, j = 2, and k = 3 then we will get
           A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
		 * 
		 */
	}

}


