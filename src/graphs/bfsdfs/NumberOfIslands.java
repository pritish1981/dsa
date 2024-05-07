package graphs.bfsdfs;

/**
 * Problem Description
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

Direction of movement 8 ways :- 

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
1 <= N, M <= 100

0 <= A[i] <= 1

Input Format
The only argument given is the integer matrix A.

Output Format
Return the number of islands.



Example Input
Input 1:

 A = [ 
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [   
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]    
     ]


Example Output
Output 1:  2
Output 2:  5


Example Explanation
Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total.
 *
 */
public class NumberOfIslands {

	static int[] dx = new int[] { 0, 1, -1, 0, 1, -1, 1, -1 };
	static int[] dy = new int[] { 1, 0, 0, -1, -1, 1, 1, -1 };
	
	static boolean[][] visited = new boolean[105][105];

	public static int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, n, m, A, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int i, int j, int n, int m, int[][] A, boolean[][] visited) {
		visited[i][j] = true;
		int di, dj;
		for (int k = 0; k < 8; ++k) {
			di = i + dx[k];
			dj = j + dy[k];
			if (di >= 0 && di < n && dj >= 0 && dj < m && A[di][dj] == 1 && !visited[di][dj])
				dfs(di, dj, n, m, A, visited);
		}
	}
	//Time Complexity: O(N*M), Space Complexity: O(N*M)

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 },
				         { 0, 0, 1 },
				         { 1, 0, 0 } };
		System.out.println("Numbers of islands :: " + solve(grid));

	}

}
