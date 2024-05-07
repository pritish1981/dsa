/**
 * 
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 */
public class RottenOranges {

	static class Pair {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	public static int rottenOranges(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 2)
					q.add(new Pair(i, j));
			}
		}
		// All 4 directions to move
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int time = 0;// time counter
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				int first = p.first;
				int second = p.second;
				for (int k = 0; k < 4; k++) {
					int x = dx[k] + first;
					int y = dy[k] + second;
					if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] == 1) {
						A[x][y] = 2;
						q.add(new Pair(x, y));
					}
				}
			}
			time++;
		}
		// check if any fresh oranges are remaining & not able to rotten
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1)
					return -1;
			}
		}
		return time - 1; // don't count when last orange is also rotten

	}

	public static void main(String[] args) {
		int[][] A = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("Time taken to rotten all oranges in the grid::" + rottenOranges(A));

	}

}
