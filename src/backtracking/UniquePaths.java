/**
 * 
 */
package backtracking;

/**
 * You are given an m x n integer array grid where grid[i][j] could be:
1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.
 */
public class UniquePaths {

/**
 * Explanation:
    1.Count totalSteps needed to reach dest using all valid blocks.
    2.Also store start position, in the same loop.
    3.Using recursive func, find the path to dest with steps == totalSteps.
    4.Once found, don't end recursion completely here. Stop that branch only, then do backtracking and find new paths
       if available using the for loop of direction vector.
	 */
	
	static int m, n;
    static int totalSteps = 0;
    static  int count = 0;
    // 1 - source, 2 - destination, 0- empty square, -1 - obstacle

	public static int uniquePaths(int[][] A) {
		m = A.length;
		n = A[0].length;
		int startX = 0, startY = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 0 || A[i][j] == 2)
					totalSteps++;
				if (A[i][j] == 1) {
					startX = i;
					startY = j;
				}
			}

		path(A, startX, startY, 0);

		return count;

	}
    public static  void path(int[][] matrix, int r, int c, int steps) {
    	//base case
    	if(steps == totalSteps && matrix[r][c] == 2){
            count++;
            return;
        }
    	
    	if(matrix[r][c] == 2)     
            return; 
    	
    	//Direction of vector
    	
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        
		for (int i = 0; i < 4; i++) {

			int nr = r + dx[i];
			int nc = c + dy[i];

			if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] != -1 && matrix[nr][nc] != 1) {
				
				steps++;
				
				if (matrix[nr][nc] != 2) {
					matrix[nr][nc] = -1;
				}

				path(matrix, nr, nc, steps);

				// backtracking lines:
				steps--;
				if (matrix[nr][nc] == -1) {
					matrix[nr][nc] = 0;
				}
			}
		}
    }
    
	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0, 0 },
				         { 0, 0, 0, 0 },
				         { 0, 0, 2, -1 }
				       };
	    System.out.println(uniquePaths(grid));
	}

}
