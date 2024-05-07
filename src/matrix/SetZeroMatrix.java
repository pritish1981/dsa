/**
 * 
 */
package matrix;

/**
 * @author Pritish
 *
 */
public class SetZeroMatrix {

	public static void setZeroes(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		boolean row = false, col = false;

		for (int i = 0; i < n; i++) {
			if (mat[i][0] == 0)
				col = true;
		}
		for (int j = 0; j < m; j++) {
			if (mat[0][j] == 0)
				row = true;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (mat[i][j] == 0) {
					mat[0][j] = 0;
					mat[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < n; i++) {
			if (mat[i][0] == 0) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < m; j++) {
			if (mat[0][j] == 0) {
				for (int i = 0; i < n; i++) {
					mat[i][j] = 0;
				}
			}
		}

		if (row) {
			for (int j = 0; j < m; j++) {
				mat[0][j] = 0;
			}
		}

		if (col) {
			for (int i = 0; i < n; i++) {
				mat[i][0] = 0;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 0, 6, 3, 0 },
			                           { 1, 8, 9, 3 }, 
			                           { 6, 2, 0, 7 } };
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		setZeroes(matrix);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}  
        
	

}
