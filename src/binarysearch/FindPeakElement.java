/**
 * 
 */
package binarysearch;

/**
 * Given an array arr[] of integers. Find a peak element i.e. an element that is not smaller than its neighbors. 
 *
 */
public class FindPeakElement {

	static int findPeak(int[] A) {
		int n = A.length;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > A[mid + 1]) // you are in decreasing part of array
				end = mid;
			else if (A[mid] < A[mid + 1]) {
				start = mid + 1;
			}
		}
		return A[start];
	}
  // Time Complexity: O(logN), Space Complexity: O(1)
	
	public static void main(String[] args) {
		 int arr[] = { 1, 3, 20, 4, 1, 0 };
		 System.out.print(findPeak(arr));

	}

}
