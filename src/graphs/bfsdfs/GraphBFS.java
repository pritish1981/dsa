/**
 * 
 */
package graphs.bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth First traversal of a graph or level order traversal
 *
 */
public class GraphBFS {

	private int V; // no of vertices
	private List<List<Integer>> adj; // adjacency list of graph

	// constructor
	GraphBFS(int V) {
		this.V = V;
		adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	// add edges to the graph
	void insertEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	//BFS traversal
	void bfs(int src) {
		//Mark all the vertices as unvisited or false 
		boolean visited[] = new boolean[V];
		//create a queue for BFS
		Queue<Integer> q = new LinkedList<>();
		//mark the current node as visited & add to the queue
		visited[src] = true;
		q.add(src);
		
		while(!q.isEmpty()) {
			src = q.poll();
			System.out.print(src +  " ");
			//Get all adjacent vertices of dequeued vertex
			for (int nbr : adj.get(src)) {
				if (!visited[nbr]) {
					visited[nbr] = true;
					q.add(nbr);
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphBFS g = new GraphBFS(7);
		g.insertEdge(0, 1);
		g.insertEdge(0, 3);
		g.insertEdge(1, 4);
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		g.insertEdge(4, 5);
		g.insertEdge(4, 6);
		g.insertEdge(5, 6);
		System.out.println("The BFS traversal of the given graph starting from node 0 is -");
		g.bfs(0);

	}

}
