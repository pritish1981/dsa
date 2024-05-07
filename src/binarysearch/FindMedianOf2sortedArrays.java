/**
 * 
 */
package binarysearch;

/**
 * Find median of two sorted arrays of different size using Binary Search
 *
 */
public class FindMedianOf2sortedArrays {
	//Time Complexity:O(min(log N, log M), Space Complexity: O(1)

	static double findMedian(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		// if the first array is larger then swap
		if (n > m)
			return findMedian(B, A);

		int start = 0;
		int end = n;
		int mergedMid = (n + m + 1) / 2;

		while (start <= end) {
			// we are using MIN and MIX to maintain the overflow range
			// checking overflow of indices
			int mid = (start + end) / 2;
			int A_left_size = mid;
			int B_left_size = mergedMid - mid;

			int A_left = (A_left_size > 0) ? A[A_left_size - 1] : Integer.MIN_VALUE;
			int B_left = (B_left_size > 0) ? B[B_left_size - 1] : Integer.MIN_VALUE;
			int A_right = (A_left_size < n) ? A[A_left_size] : Integer.MAX_VALUE;
			int B_right = (B_left_size < m) ? B[B_left_size] : Integer.MAX_VALUE;

			// if the correct partioning is done then check further else change the start or
			// end pointer
			if (A_left <= B_right && B_left <= A_right) {
				if ((m + n) % 2 == 0)
					return (Math.max(A_left, B_left) + Math.min(A_right, B_right)) / 2.0;
				return Math.max(A_left, B_left);
			} else if (A_left > B_right) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return 0.0;
	}
	
	public static void main(String args[]) {
        int a1[] = { 1, 2, 3, 6 };
        int a2[] = { 4, 7, 8, 10, 22 };
        System.out.println(
                "The median of two sorted arrays is: " + findMedian(a1, a2));
    }
}
