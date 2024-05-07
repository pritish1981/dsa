/**
 * 
 */
package binarysearch;

/**
 * Given N distinct elements in an arry, Array is unsorted, Find element at K'th position in  its's sorted form.
 *
 */
public class FindKthElementInUnsortedArray {

	// function to calculate no of elements <= mid
	static int count(int[] arr, int mid) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= mid) {
				count++;
			}
		}
		return count;
	}

	static int KthSmallest(int[] arr, int k) {
		int n = arr.length;
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;

		// calculate min & max from the array
		for (int i = 0; i < n; i++) {
			start = Math.min(start, arr[i]);
			end = Math.max(end, arr[i]);
		}
		// Our answer range lies between minimum and maximum element of the array on
		// which Binary Search is Applied
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (count(arr, mid) < k) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 5, 3, 19, 3 };
		int k = 3;
		System.out.print("Kth smallest element is " + KthSmallest(arr, k));

	}

}
