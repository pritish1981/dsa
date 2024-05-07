/**
 * 
 */
package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A

Input Format
The first argument given is an integer A.

The second argument given is the matrix B.

Output Format
Return 1 if the given graph is bipartide else return 0.

Example Input
Input 1:

A = 2
B = [ [0, 1] ]
Input 2:

A = 3
B = [ [0, 1], [0, 2], [1, 2] ]


Example Output
Output 1: 1
Output 2: 0


Example Explanation
Explanation 1:

Put 0 and 1 into 2 different subsets.
Explanation 2:

 
It is impossible to break the graph down to make two different subsets for bipartite matching
 *
 */
public class CheckBipartite {

	static int maxn = 100009;
	static ArrayList<ArrayList<Integer>> adj;

	public static void graph() {
		adj = new ArrayList<ArrayList<Integer>>(maxn);
		for (int i = 0; i < maxn; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public static int solve(int A, int[][] B) {
		graph();
		for (int[] edge : B) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		if (isBipartite(A) == true)
			return 1;
		return 0;
	}

	public static boolean isBipartite(int n) {
		if (n == 0)
			return true;
		int[] color = new int[n];
		Arrays.fill(color, -1);
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; ++i) {
			if (color[i] != -1)
				continue;
			color[i] = 1;
			q.offer(i);
			while (!q.isEmpty()) {
				int x = q.poll();
				for (int nbr : adj.get(x)) {
					if (color[nbr] == -1) {
						color[nbr] = 1 - color[x];
						q.offer(nbr);
					} else if (color[nbr] == color[x])
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int A = 4;
		int[][] B = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		System.out.println(solve(A, B));
		// return 1 if bipartite else return 0
	}

}
