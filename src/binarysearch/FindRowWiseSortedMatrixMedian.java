/**
 * 
 */
package binarysearch;

import java.util.Arrays;

/**
 * @author Pritish
 *
 */
public class FindRowWiseSortedMatrixMedian {
	
	static int matrixMedian(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < r; i++) {

			// Finding the minimum element
			if (mat[i][0] < min)
				min = mat[i][0];

			// Finding the maximum element
			if (mat[i][c - 1] > max)
				max = mat[i][c - 1];
		}

		int desired = (r * c + 1) / 2;
		while (min < max) {
			int mid = min + (max - min) / 2;
			int place = 0;
			int get = 0;

			// Find count of elements smaller than or equal
			// to mid
			for (int i = 0; i < r; ++i) {

				get = Arrays.binarySearch(mat[i], mid);

				// If element is not found in the array the
				// binarySearch() method returns
				// (-(insertion_point) - 1). So once we know
				// the insertion point we can find elements
				// Smaller than the searched element by the
				// following calculation
				if (get < 0)
					get = Math.abs(get) - 1;

				// If element is found in the array it
				// returns the index(any index in case of
				// duplicate). So we go to last index of
				// element which will give the number of
				// elements smaller than the number
				// including the searched element.
				else {
					while (get < mat[i].length && mat[i][get] == mid)
						get += 1;
				}

				place = place + get;
			}

			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}
		return min;

	}
	public static void main(String[] args) {
		int m[][]
	            = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		System.out.println("Median is "
                + matrixMedian(m));

	}

}
