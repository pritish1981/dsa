/**
 * 
 */
package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Problem Description
Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.


Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 1


Input Format
The first argument given is the integer matrix A.

Output Format
Return the matrix B.

Example Input
Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1] 
       [0, 1, 1, 0]
     ]
Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]  
     ]


Example Output
Output 1:

 [ 
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]   
 ]
Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4] 
 ]


Example Explanation
Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
Explanation 2:

 There is only a single 1. Fill the distance from that 1.
 *
 */
public class DistanceOfNearestCell {
	
	/*Solution Approach:
	 * The idea is to load the i and j coordinates of each ‘1′ in the Matrix into a Queue and then traverse all the “0�? Matrix elements and compare the distance 
	 * between all the  1’s from the Queue to get a minimum distance
	 * 
	 *  grid[i][j]==0 means this is the starting point and grid[i][j]==INT_MAX is imaginary distance. 
	 *  this concept will be used for visited and unvisited purposes. Only grid[i][j]==INT_MAX will be treated as unvisited, everything else will be treated as visited. 

1.Create a queue<pair<int,int>> q
2.Traverse the matrix and do two tasks if (grid[i][j]==1) { q.push( { i , j } ); grid[ i ][ j ] = 0; }    else { grid[ i ][ j ] = INT_MAX; }
3.Now do a BFS traversal of the graph using the above-created queue.
4.Run while loop till the size of the queue is greater than 0 then extract the front node of the queue and remove it and 
5.insert all its valid adjacent nodes if (grid[ i ][ j ] = INT_MAX) // it means this node is unvisited till now.
	 * 
	 * 
	 */
	
	static class pair {
		int first, second;

		pair(int f, int s) {
			first = f;
			second = s;
		}
	}

	public static int[][] solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		Queue<pair> q = new ArrayDeque<>();
		// to do multisource Breadth-First Search store the initial index of 1s
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] != 0) {
					q.add(new pair(i, j));
					A[i][j] = 0;// mark the starting index as 0
				} else {
					A[i][j] = Integer.MAX_VALUE;// rest marked as infinity or not visited
				}
			}
		}
		
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 }; // up, down, left, right

		while (!q.isEmpty()) {
			pair top = q.peek();
			q.poll();
			int x = top.first;// current
			int y = top.second; // current
			int time = A[x][y];// time of current distance at index (x,y)
			
			for (int i = 0; i < 4; i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && A[nr][nc] == Integer.MAX_VALUE) {
					// only for non-visited
					A[nr][nc] = time + 1;// time of current distance at index(x,y) + 1
					q.add(new pair(nr, nc));
				}
			}
		}
		return A;
	}
 
	//Time Complexity: O(N*M), Space complexity: O(N*M)
	
	public static void main(String[] args) {
		int[][] A = { { 0, 0, 0, 1 },
				      { 0, 0, 1, 1 },
				      { 0, 1, 1, 0 } };
		int[][] ans = solve(A);
		System.out.println(
				"So matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A"
						+ Arrays.deepToString(ans));
	}

}
