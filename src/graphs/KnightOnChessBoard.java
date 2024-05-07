/**
 * 
 */
package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem Description
Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints
1 <= A, B <= 500



Input Format
The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.



Output Format
If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.



Example Input
Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4


Example Output
Output 1:  6
Output 2: -1


Example Explanation
Explanation 1:

 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.
Explanation 2:

 It is not possible to move knight to position (4, 4) from (2, 1)
 *
 */
public class KnightOnChessBoard {

	static int[][] knightDirections = new int[][] { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 },
			{ -1, 2 }, { -1, -2 } };

	static class Edge {
		int row, col, step;

		public Edge(int row, int col, int step) {
			this.row = row;
			this.col = col;
			this.step = step;
		}
	}

	public static int knight(int A, int B, int C, int D, int E, int F) {
		Queue<Edge> q = new ArrayDeque<>();// BFS from source
		q.offer(new Edge(C, D, 0)); // 0 steps for source
		boolean visited[][] = new boolean[A + 1][B + 1];// visited array
		visited[C][D] = true;// mark source as visited

		while (!q.isEmpty()) {
			Edge e = q.poll(); // poll the edge
			int r = e.row;
			int c = e.col;
			int step = e.step;
			if (r == E && c == F) // if we reach destination
				return step;
			for (int[] direction : knightDirections) { // for all directions
				int nr = r + direction[0]; // new row
				int nc = c + direction[1]; // new col

				if (nr >= 1 && nr <= A && nc >= 1 && nc <= B && !visited[nr][nc]) {
					q.offer(new Edge(nr, nc, step + 1));
					visited[nr][nc] = true; // mark as visited
				}
			}
		}
		return -1;
	}
	// Time Complexity: O(A*B) | Space Complexity: O(A*B)

	public static void main(String[] args) {
		System.out.println(knight(8, 8, 1, 1, 8, 8));

	}

}
