/**
 * 
 */
package backtracking;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chess board such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 */
public class NQueens1 {

	public static int totalNQueens(int n) {
		char[][] board = new char[n][n];
		return queens(board, 0);
	}

	static int queens(char[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		// placing the queens and checking for every row and col
		for (int col = 0; col < board.length; col++) {
			// place the queen if it is safe
			if (isSafe(board, row, col)) {
				board[row][col] = 'Q'; //change
				count += queens(board, row + 1);//recursive call for next iteration
				board[row][col] = '.'; //undo change
			}
		}
		return count;
	}

	// checks all pssible safe blocks for the queens
	static boolean isSafe(char[][] board, int row, int col) {
		for (int i = 0; i < row; i++) { // queen placed at any column of 1st row
			if (board[i][col] == 'Q')
				return false;
		}
		// Check upper diagonal on left side
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		// upper diagonal on right side
		for (int i = row - 1, j = col + 1; i >= 0 && j <board.length; i--, j++) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println("the number of distinct solutions to the n-queens puzzle is :: "+totalNQueens(n));
	}

}
