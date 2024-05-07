/**
 * 
 */
package backtracking;

/**
 * https://leetcode.com/problems/word-search/description/
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
  The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
  The same letter cell may not be used more than once.
 */
public class WordSearch {

	static boolean[][] visited;

	public static boolean exist(char[][] board, String word) {
		int n = board.length, m = board[0].length;
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == word.charAt(0) && findWord(board, i, j, 0, word, visited))
					return true;
			}
		}
		return false;
	}
	// convert String array to char array
	/*
	 * char[][] board = new char[A.length][]; for (int i = 0; i < A.length; i++) {
	 * board[i] = A[i].toCharArray(); }
	 */

	public static boolean findWord(char[][] board, int i, int j, int index, String word, boolean visited[][]) {
		int n = board.length, m = board[0].length;
		if (index == word.length())
			return true;
		int x[] = { -1, 0, 1, 0 };
		int y[] = { 0, -1, 0, 1 };
		for (int k = 0; k < 4; k++) {
			int ni = i + x[k];
			int nj = j + y[k];
			if (ni >= 0 && ni <= n && nj >= 0 && nj <= m && visited[ni][nj] == false
					&& word.charAt(index) == board[i][j]) {
				visited[ni][nj] = true;

				if (findWord(board, ni, nj, index + 1, word, visited) == true) {
					return true;
				}
			}
		}
		return false;
	}

	// TC: O(m * n), SC: O(m * n)
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(exist(board, word));

	}

}
