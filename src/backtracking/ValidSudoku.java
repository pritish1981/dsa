/**
 * 
 */
package backtracking;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 *
 */
public class ValidSudoku {

	static boolean sudoku(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				char ch = board[row][col];
				if (ch != '.') {
					board[row][col] = '.';
					if (!isValid(board, row, col, ch))
						return false;
					board[row][col] = ch;
				}
			}
		}
		return true;
	}

	static boolean isValid(char[][] board, int row, int col, char ch) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == ch || board[row][i] == ch) {
				return false;
			}
		}
		row = row - (row % 3);
		col = col - (col % 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row + i][col + j] == ch) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println((sudoku(board) ? "YES" : "NO"));

	}

}
