/**
 * 
 */
package dp.one;

/**
 * Given an integer array A of size N. Find the contiguous subarray within the given array 
 * (containing at least one number) which has the largest product.  Return an integer corresponding to the maximum product possible.
 *
 */
public class MaxProductSubArray {

	public static int maxProduct(final int[] A) {
		if (A.length == 0)
			return 0;
		int max_so_far = A[0];
		int min_so_far = A[0];
		int result = max_so_far;

		for (int i = 1; i < A.length; i++) {
			int curr = A[i];
			int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
			//min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

			max_so_far = temp_max;
			result = Math.max(max_so_far, result);
			
			
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A = { -2, 6, 4 };
		System.out.println("Max product possible::" + maxProduct(A));
       // T.C: O(N), S.C: O(1)
	}

}
