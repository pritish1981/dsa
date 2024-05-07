/**
 * 
 */
package binarysearch;

/**
 * Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k�th position of the final sorted array.
 *
 */
public class KthElementIn2SortedArrays {
	static long maxN = (long) 1e10;
	static int upperBound(int[] a, int low, int high, long element) {
		while (low < high) {
			int middle = (low+high) / 2;
			if (a[middle] > element)
				high = middle - 1;
			else
				low = middle + 1;
		}
		return low;
	}
	static long kthElement(int A[], int B[], int k) {
		int n = A.length, m = B.length;
		long left = 1, right = maxN; // The range of where ans can lie.
		long ans = (long) 1e15; // We have to find min of all the ans so take .
		while (left <= right) {
			long mid = (left + right) / 2;
			long x = upperBound(A, 0, n, mid);
			x += upperBound(B, 0, m, mid);

			if (x >= k) {
				ans = Math.min(ans, mid); // find the min of all answers.
				right = mid - 1; // Try to find a smaller answer.
			} else
				left = mid + 1; // Current mid is too small so shift right.
		}
		return ans;
	}
	public static void main(String[] args) {
		int A[] = { 3, 8, 9, 11, 24, 40 };
		int B[] = { 5, 18, 27, 35 };
		int k = 4;
		System.out.println("K'th element in two sorted array is:" + kthElement(A, B, k));

	}

}
