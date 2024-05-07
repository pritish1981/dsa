/**
 * 
 */
package graphs.bfsdfs;

/**
 * Problem Description

Given character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Problem Constraints

1 <= |A|,|A[0]| <= 1000

A[i][j] = 'X' or 'O'

Input Format:  The First and only argument is character matrix A.

Output Format: Return a single integer denoting number of black shapes.

Example Input:

Input 1:  A = [ [X, X, X], [X, X, X], [X, X, X] ]
Input 2:  A = [ [X, O], [O, X] ]


Example Output:

Output 1: 1
Output 2: 2


Example Explanation

Explanation 1:

 All X's belong to single shapes
Explanation 2:

 Both X's belong to different shapes
 *
 */
public class BlackShapes {
	
	public static int black(String[] A) {
		int count = 0;
		if (A == null || A.length == 0)
			return count;
		int n = A.length;
		int m = A[0].length();

		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] c = A[i].toCharArray();
			for (int j = 0; j < m; j++) {
				if (c[j] == 'X' && !visited[i][j]) {
					dfs(A, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(String[] A, int row, int col, boolean[][] visited) {

		if (visited[row][col]) {
			return;
		}

		visited[row][col] = true;
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			int nRow = row + dx[k];
			int nCol = col + dy[k];

			if (nRow >= 0 && nRow < A.length && nCol >= 0 && nCol < A[0].length() && A[nRow].charAt(nCol) == 'X') {
				dfs(A, nRow, nCol, visited);
			}
		}
	}

	public static void main(String[] args) {
		String[] A = { "OOOXOOO", "OOXXOXO", "OXOOOXO" };
		System.out.println("No.of black shapes:: " + black(A));

	}

}
