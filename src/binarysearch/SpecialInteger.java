/**
 * 
 */
package binarysearch;

/**
 * Given an array of integers A and an integer B, find and return the maximum value K such that 
 * there is no subarray in A of size K with the sum of elements greater than B.
 *
 */
public class SpecialInteger {

	public static int solve(int[] A, int B) {
		int n = A.length;
		int left = 1, right = n, ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int maxSubArraySum = max_subArraySum_with_given_length(A, mid);
			if (maxSubArraySum <= B) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	// sliding-window approach
	public static int max_subArraySum_with_given_length(int[] A, int k) {
		int n = A.length;
		if (n < k)
			return -1;
		// compute sum of 1st window of size k
		int ans = 0;
		for (int i = 0; i < k; i++) {
			ans += A[i];
		}
		// Compute sums of remaining windows by removing first element of previous window
		// and adding last element of current window
		int cur_sum = ans;
		for (int i = k; i < n; i++) {
			cur_sum += A[i] - A[i - k];
			ans = Math.max(ans, cur_sum);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int B = 10;
		System.out.println(solve(A, B));

	}

}
