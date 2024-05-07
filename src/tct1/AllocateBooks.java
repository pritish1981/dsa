/**
 * 
 */
package tct1;

/**
 * Given an array of integers A of size N and an integer B.
The College library has N books. The ith book has A[i] number of pages.
You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

Calculate and return that minimum possible number.
NOTE: Return -1 if a valid assignment is not possible.
 *
 */
public class AllocateBooks {

	static boolean isPossibleSol(int[] arr, int b, int m) {
		int students = 1;
		int spc = 0; //student page count
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > m) {
				return false;
			}
			if (spc + arr[i] <= m) {
				spc = spc + arr[i];
			} else {
				students++;
				if (students > b) {
					return false;
				}
				spc = arr[i];
			}
		}
		return true;
	}

	static int maxPage(int[] arr, int b) {
		if (b > arr.length) {
			return -1;
		}
		int l = arr[0], h = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < l) {
				l = arr[i];
			}
			h = h + arr[i];
		}
		int res = -1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (isPossibleSol(arr, b, m) == true) {
				res = m;
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 34, 67, 90 };
		int b = 2;
		System.out.println("Minimum number of pages = " + maxPage(arr, b));

	}
	//Time Complexity: N log(sum(arr))

}
