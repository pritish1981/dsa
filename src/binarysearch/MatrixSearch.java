/**
 * 
 */
package binarysearch;

/**
 * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
NOTE: Rows are numbered from top to bottom, and columns are from left to right.
 *
 */

/*Since each row is sorted from left to right, and by the second condition we can conclude that columns are sorted
 * from top to bottom as well.We can use two binary search here, first binary search will find the row where element can be present,
 * and second binary search will find the element in that row if present. */

public class MatrixSearch {

	static int searchMatrix(int[][] A, int B) {
		int n = A.length;
		int m = A[0].length;
		// Base conditions.
		if (n == 0)   return 0;
		if (A[n - 1][m - 1] < B) 	return 0;
		if (A[0][0] > B) 	return 0;

		int start = 0, end = n;
		while (start < end) {
			int row = (start + end) / 2;

			// Found Cut
			if (A[row][0] <= B && B <= A[row][m - 1]) {
				int l = 0, r = m;
				while (l < r) {
					int mid = (l + r) / 2;
					// Found Cut
					if (A[row][mid] == B) 
						return 1;

					if (A[row][mid] > B)
						r = mid;
					else
						l = mid + 1;
				}
				return 0; // If given element is not present.
			}

			if (A[row][0] > B)
				end = row;
			else
				start = row + 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		int[][] A = {{ 1,   3,  5,  7},
			         {10, 11, 16, 20},
			         {23, 30, 34, 50} };
			int B = 23;
			
			System.out.println(searchMatrix(A,B));

	}

}
