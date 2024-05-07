/**
 * 
 */
package graphs;

import java.util.Arrays;

/**
 * There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together. 
(A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together. 
The cost is the sum of the connection costs used. If the task is impossible, return -1.

Constraints:

1 <= N <= 10000
1 <= connections.length <= 10000
1 <= connections[i][0], connections[i][1] <= N
0 <= connections[i][2] <= 10^5
connections[i][0] != connections[i][1]

Example:
Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: 
Choosing any 2 edges will connect all cities so we choose the minimum 2.
 *
 *  Using Kruskal's algorithm
 */
public class ConnectingCityWithMinCost {

	public static int minCost(int n, int[][] connections) {
		// connections[i] = [x,y,cost]
		Arrays.sort(connections, (a, b) -> a[2] - b[2]); //sort the edges based on minimum weight
		
		int[] parent = new int[n + 1];
		int[] rank = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int cost = 0;
		int num_edges = 0;
		
       //select edges one by one if(u,v) doesn't belong to the same set, add in the MST cost.
		for (int[] connection : connections) {
			if (union(parent, rank, connection[0], connection[1])) {
				cost += connection[2];
				num_edges++;
			}
		}

		return num_edges == n - 1 ? cost : -1;

	}

	public static boolean union(int[] parent, int[] rank, int x, int y) {
		int root_x = find(parent, x);
		int root_y = find(parent, y);
		if (root_x == root_y)
			return false;
		if (rank[root_x] > rank[root_y]) {
			parent[root_y] = root_x;
		} else if (rank[root_y] > rank[root_x]) {
			parent[root_x] = root_y;
		} else {
			parent[root_y] = root_x;
			rank[root_x]++;
		}
		return true;

	}

	public static int find(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		parent[x] = find(parent, parent[x]);
		return parent[x];
	}
	
	// Time Complexity: O(E log E), Space Complexity: O(N+E)

	public static void main(String[] args) {
		int N = 3;
		int connections[][] = { { 1, 2, 5 }, { 1, 3, 6, }, { 2, 3, 1 } };
		System.out.println("Minimum costs to connect all cities :: " + minCost(N, connections));

	}

}
