/**
 * 
 */
package graphs.bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS traversal of a Graph
 *
 */
public class GraphDFS {

	private int V; // no of vertices
	private List<List<Integer>> adj; // adjacency list of graph

	// constructor
	GraphDFS(int V) {
		// initializing V and adjList
		this.V = V;
		adj = new ArrayList<>();
		// inserting V empty lists in the adjacency list
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	// add edges to the graph
	void insertEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	// DFS function
	void dfs(int u) {
		boolean visited[] = new boolean[V];
		dfs_helper(u, visited);
	}

	// helper function for DFS
	void dfs_helper(int u, boolean visited[]) {
		visited[u] = true;
		System.out.print(u + " ");
		// checking for all nodes adjacent to u
		for (int nbr : adj.get(u)) {
			if (!visited[nbr]) {
				dfs_helper(nbr, visited);
			}
		}
	}

	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(7);
		g.insertEdge(0, 1);
		g.insertEdge(0, 3);
		g.insertEdge(1, 4);
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		g.insertEdge(4, 5);
		g.insertEdge(4, 6);
		g.insertEdge(5, 6);
		System.out.println("The DFS traversal of the given graph starting from node 0 is -");
		g.dfs(0);
	}

}
