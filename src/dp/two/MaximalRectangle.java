/**
 * 
 */
package dp.two;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 */
public class MaximalRectangle {

	public static int tabulation(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				if (matrix[i][j] == 0)
					continue;
				if (matrix[i][j] == 1) {
					matrix[i][j] = j - 1 >= 0 ? 1 + matrix[i][j - 1] : 1;
				}
			}
		}
		int area = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}
				int width = matrix[i][j];
				int height = 1;
				area = Math.max(area, width * height);
				for (int k = i - 1; k >= 0; k--) {
					if (matrix[k][j] < width) {
						width = matrix[k][j];
					}
					height++;
					area = Math.max(area, width * height);
				}
			}
		}
		return area;
	}

	public static int dynamicProgramming(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
			}
		}
		return tabulation(dp);
	}

	public static int maximalRectangle(int[][] matrix) {
		// return monotonicStack(matrix);
		return dynamicProgramming(matrix);
	}
	 //TC : O(n * n) || SC :  (1)
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 0, 0 } };

		System.out.println(maximalRectangle(matrix));
	}

}
