/**
 * 
 */
package binarysearch;

import java.util.Arrays;

/**
 * Given an integer array A of size N.
If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
 *
 */
public class FindSmallestAgain {

	public static int solve(int[] A, int B) {
		Arrays.sort(A);
		int n = A.length, ans = 0;
		int left = A[0] + A[1] + A[2];
		int right = A[n - 3] + A[n - 2] + A[n - 1];

		while (left <= right) {
			int mid = (left + right) / 2;
			// calculate count of triplets less than equals to mid
			int count = count_of_triplets_sum_lessThanMid(A, mid);
			if (count < B) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	// two pointer approach
	public static int count_of_triplets_sum_lessThanMid(int[] A, int target) {
		int count = 0, n = A.length;
		for (int i = 0; i < n; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (A[i] + A[j] + A[k] < target) {
					j++;
					count += k - j;
				} else {
					k--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] A = { 2, 4, 3, 2 };
		int B = 3;
		System.out.println(solve(A, B));

	}

}
