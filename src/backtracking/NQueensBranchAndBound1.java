/**
 * 
 */
package backtracking;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chess board such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 */
public class NQueensBranchAndBound1 {

	// Boolean arrays to store information about the placed queens.
	static boolean rightDiagonal[];
	static boolean leftDiagonal[];
	static boolean column[];
	static int count;

	// Function to check if it is safe to place queen in the cell (row, col) such that
	// it does not attack any other queen.
	static boolean isQueenSafe(int i, int j, int n){
        if(column[j] == true)    return false;
        if(rightDiagonal[i + j] == true) return false;
        if(leftDiagonal[i - j + n - 1] == true) return false;
        
        return true;
    }
	
	static void queens(int row, int n) {
		if (row == n) {
			count++;
			return;
		}
		
		for (int col = 0; col < n; col++) {
			if (isQueenSafe(row, col, n) == true) {
				column[col] = true;
				rightDiagonal[row + col] = true;
				leftDiagonal[row - col + n - 1] = true;

				queens(row + 1, n);

				column[col] = false;
				rightDiagonal[row + col] = false;
				leftDiagonal[row - col + n - 1] = false;
			}
		}
	}

	// Function to Solve the NQueen Problem
	 public static int totalNQueens(int n) {
	        if(n == 1)  return 1;
	        if(n == 2 || n == 3)    return 0;
	        
	        column = new boolean[n];
	        rightDiagonal = new boolean[2 * n - 1];
	        leftDiagonal = new boolean[2 * n - 1];
	        count = 0;
	        queens(0, n);
	        return count;
	    }

	public static void main(String[] args) {
		int n = 4;
		System.out.println("the number of distinct solutions to the n-queens puzzle is :: "+totalNQueens(n));
		 //T.C: O(N!), S.C: O(N^2)

	}

}
