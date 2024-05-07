/**
 * 
 */
package binarysearch;

import java.util.Arrays;

/**
 * Given an array of integers A of size N and an integer B.
In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences,
and C[1] is the number with maximum occurrence.If there are several such numbers, your task is to find the minimum one.
 *
 */
public class AddOrNot {

	public static int[] solve(int[] A, int B) {
		int n = A.length;
		// to do prefixSum
		long prefix[] = new long[n + 1];
		Arrays.sort(A);
		// create prefix array
		for (int i = 0; i < n; i++) {
			prefix[i + 1] = prefix[i] + A[i];
		}

		int ans[] = new int[2];
		ans[0] = -1;
		ans[1] = -1;

		for (int i = 0; i < n; i++) {
			int left = 1, right = i + 1, occur = 0;
			while (left <= right) {
				int mid = (left + right) / 2;
				long operations = A[i] * mid - (prefix[i + 1] - prefix[i - mid + 1]);
				if (operations <= B) {
					occur = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			// update ans
			if (ans[0] < occur) {
				ans[0] = occur;
				ans[1] = A[i];
			}
		}
		return ans;

	}
	
	
	public static void main(String[] args) {
		int[] A = {3,1,2,2,1};
		int B = 3;
		//Output = [4,2];
		int[] ans = solve(A,B);
		System.out.println(Arrays.toString(ans));

	}

}
