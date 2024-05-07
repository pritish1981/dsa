/**
 * 
 */
package backtracking;

import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chess board such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 */
public class NQueensBranchAndBound {

	// Boolean arrays to store information about the placed queens.
	static boolean leftDiagonal[];
	static boolean rightDiagonal[];
	static boolean column[];

	// Function to print the solution.
	static void printSolution(char board[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Function to check if it is safe to place queen in the cell (row, col) such that
	// it does not attack any other queen.
	static boolean isSafe(char board[][], int i, int j) {
       int n  = board.length;
		// Checking if leftDiagonal contains a queen OR rightDiagonal contains a queen OR curretnColumns contains a queen.
		    if(column[j] == true)    return false;
	        if(rightDiagonal[i + j] == true) return false;
	        if(leftDiagonal[i - j + n - 1] == true) return false;
	        
	        return true;
	}

	static boolean solutionExists(char board[][],int row) {
		int N = board.length;
		// If we have placed a queen in all the rows, it means solution exists.
		if (row >= N)
			return true;

		// Trying to place the queen in every possible cell in the 'row th' row.
		for (int col = 0; col < N; col++) {
			
			if (isSafe(board, row, col)) {
				// If found true, place a queen in the cell (row, col) and recur for the next row.
				leftDiagonal[row - col + N - 1] = true;
				rightDiagonal[row + col] = true;
				column[col] = true;
				board[row][col] = 'Q';

				if (solutionExists(board, row + 1))
					return true;
				// backtrack
				leftDiagonal[row - col + N - 1] = false;
				rightDiagonal[row + col] = false;
				column[col] = false;
				board[row][col] = '.';
			}
		}
		return false;
	}

	// Function to Solve the NQueen Problem
	static void solveNQueenProblem(int N) {
		// Defining the board, that will be used to print the result if a solution exists
		char board[][] = new char[N][];
		// Initializing all its cells to be empty at first.
		for (int i = 0; i < N; i++) {
			board[i] = new char[N];
			// '.' Represents empty cell
			Arrays.fill(board[i], '.');
		}

		// Initializing boolean arrays.
	    leftDiagonal = new boolean[2 * N - 1];
		rightDiagonal = new boolean[2 * N - 1];
		column = new boolean[N];

		// If the solution do not exists
		if (!solutionExists(board, 0)) {
			System.out.println("No solution exists for N = " + N);
		}
		// Otherwise, if the solution exists.
		else {
			System.out.println("One of the possible solution for N = " + N + " is - ");
			printSolution(board, N);
		}
	}

	public static void main(String[] args) {
		int N = 4;
		solveNQueenProblem(N);
		 //T.C: O(N!), S.C: O(N^2)

	}

}
