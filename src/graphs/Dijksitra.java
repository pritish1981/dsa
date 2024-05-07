/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem Description
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
You have to find an integer array D of size A such that:
D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.


Problem Constraints
1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A

Input Format
The first argument is an integer A, representing the number of nodes in the graph.
The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.


Output Format
Return the integer array D.



Example Input
Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6] 
        [1, 2, 1] 
        [2, 5, 1] 
        [2, 4, 5] 
        [0, 3, 7] 
        [0, 1, 1] 
        [4, 5, 7] 
        [0, 5, 1] ] 
C = 4
Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3] 
        [0, 1, 9] 
        [3, 4, 10] 
        [1, 3, 8]  ] 
C = 4


Example Output
Output 1: D = [7, 6, 5, 6, 0, 6]
Output 2: D = [14, 18, 13, 10, 0]
 *
 */

/**
 * Approach :
1.Set the distance of the source node to 0 and initially all the vertices are at distances at infinity.
2.Maintain the visited array so that we can maintain the status of all the vertices.
3.Now mark the current vertex as visited( which is source node)
4.Now the vertices which are adjacent to the present vertex , update all the distance from the source vertex which is equal to the minimum of its current distance and sum of weight of current edge.
5.Now the vertex which is unvisited , set one as the new current vertex and do the same thing as above as check if the node has minimum distance till now or if it is not then update it with the summation of the current node distance and current edge weight.
6.Repeat steps 3-5 until all vertices are flagged as visited.
 */
public class Dijksitra {

	static class Pair {
		int source;
		int destination;
		int weight;

		public Pair(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

	}

	public static int[] solve(int V, int[][] edges, int src) { // V : no of nodes

		// step1: create an adjacency list
		ArrayList<Pair> adj[] = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		//create edges in the graph
		for (int i = 0; i < edges.length; i++) {
			int source = edges[i][0];
			int destination = edges[i][1];
			int weight = edges[i][2];
			adj[source].add(new Pair(source, destination, weight));
			adj[destination].add(new Pair(destination, source, weight));

		}
		// step2: Getting shortest distance from Source to node i
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		pq.add(new Pair(src, src, 0));
		while (!pq.isEmpty()) {
			Pair rp = pq.poll();
			int u = rp.destination;
			int w = rp.weight;
			if (w > dist[u])
				continue;

			for (Pair nbr : adj[u]) {
				int v = nbr.destination;
				int weight = nbr.weight;
				if (dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;//weight so far
					pq.add(new Pair(u, v, dist[v]));
				}
			}
		}

		// check if all nodes are reachable
		for (int i = 0; i < V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				dist[i] = -1;
		}
		return dist;
	}

	public static void main(String[] args) {
		int A = 5;
		int[][] B = { { 0, 3, 4 },
				      { 2, 3, 3 },
				      { 0, 1, 9 },
				      { 3, 4, 10 },
				      { 1, 3, 8 } };
		int C = 4;
		int[] ans = solve(A, B, C);
		System.out.println(Arrays.toString(ans));

	}


}



