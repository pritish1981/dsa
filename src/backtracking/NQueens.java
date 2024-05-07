/**
 * 
 */
package backtracking;

import java.util.Arrays;

/**
 * The N-Queen is the problem of placing n queens on a chess board of dimensions 
   n�n such that no queen can attack another queen in a single move.
 *
 */
public class NQueens {

	// Function to print the solution.
    static void printSolution(char board[][]){
         for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Function to check if it is safe to place queen in the cell (row, col) such that it does not attack any other queen.
    
	static boolean isSafe(char board[][], int row, int col) {
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
    
	static boolean solutionExists(char board[][],int row) {
		// If we have placed a queen in all the rows, it means solution exists.
		if (row >= board.length)
			return true;
		// try all possibilities
		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 'Q'; //change
				if (solutionExists(board, row + 1)) //recursive call for next iteration
					return true;
				board[row][col] = '.';//undo the change
			}
		}
		return false;
	}
    
    static void solveNQueenProblem(int N) {
    	// Defining the board, that will be used to print the result if a solution exists
        char board[][] = new char[N][];
        // Initializing all its cells to be empty at first.
        for(int i = 0; i < N; i++){
            board[i] = new char[N];
            // '.' Represents empty cell
            Arrays.fill(board[i], '.');
        }
        // If the solution do not exists
        if(!solutionExists(board, 0)){
            System.out.println("No solution exists for N = "+ N);
        } 
        // Otherwise, if the solution exists.
        else{
            System.out.println("One of the possible solution for N = "+N+" is - ");
            printSolution(board);
        }
    }
	public static void main(String[] args) {
		int N = 4;
        solveNQueenProblem(N);
        //T.C: O(N!), S.C: O(N^2 + N)
	}

}
