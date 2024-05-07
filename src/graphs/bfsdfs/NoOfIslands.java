/**
 * 
 */
package graphs.bfsdfs;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Direction of movement - 4 ways up-down-left-right

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 *
 */
public class NoOfIslands {
	//idea: from every unvisited 1's call dfs
	// direction of movement  4 ways up-down-left-right
	static boolean[][] visited = new boolean[105][105];

	public static int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, n, m, visited, A);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int i, int j, int n, int m, boolean visited[][], int[][] A) {
		visited[i][j] = true;
		int[] dx = new int[] { 0, 1, -1, 0 };
		int[] dy = new int[] { 1, 0, 0, -1 };
		int ni, nj;
		for (int k = 0; k < 4; ++k) {
			ni = i + dx[k];
			nj = j + dy[k];
			if (ni >= 0 && ni < n && nj >= 0 && nj < m && A[ni][nj] == 1 && !visited[ni][nj])
				dfs(ni, nj, n, m, visited, A);
		}
	}
	//Time Complexity: O(N*M), Space Complexity:O(N*M)

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 },
				         { 0, 0, 1 },
				         { 1, 0, 0 } };
		System.out.println("Numbers of islands :: " + solve(grid));

	}


}
