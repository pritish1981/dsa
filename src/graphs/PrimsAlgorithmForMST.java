/**
 * Find minimum spanning tree using Prim's algorithm
 */
package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * steps:
 * 1.select any node as root node & mark it visited
 * 2.Insert all the connected edges of the root node in minHeap.
 * 3.while(minHeap.size() >0){
 *      a. remove the edge with minimum weight from minHeap
 *      if(visited[v]==true)c{continue}
 *      else{
 *       visited[v] = true;
 *       ans+= weight;
 *       for({w, nbr}: adj[v]{
 *       if(!visited[nbr]{
 *         minHeap.insert(w,nbr);}
 *          
 *
 */
public class PrimsAlgorithmForMST {

	static class Graph{
		int V; //no of vertices
		ArrayList<ArrayList<Node>> adj;//adjancency list of graph
		
		//inner class Node to represent an edge (destination, weight)
		class Node{
			int dest;
			int weight;
			Node(int dest, int weight){
				this.dest = dest;
				this.weight = weight;
				}
		}
		
		//constructor
		Graph(int V){
			this.V = V;
			adj = new ArrayList<>(V);
			for(int i=0;i<V;i++) {
				adj.add(new ArrayList<>());
			}
		}
		
		//function to add edges in the graph
		void addEdge(int src, int dest, int weight) {
			adj.get(src).add(new Node(dest, weight));
			adj.get(dest).add(new Node(src, weight));
		}
		
		//Function to find minimum spanning tree using Prim's algorithm
		void primMST() {
			int[] parent = new int[V];
			int[] key = new int[V];
			boolean visited[] = new boolean[V];
			
			for(int i=0;i<V;i++) {
				parent[i]= -1;//array to store parent node of each vertex in MST
				key[i]= Integer.MAX_VALUE;// array to store minimum key value for each vertex
				visited[i]= false;
			}
			
			PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.weight - b.weight);
			key[0]=0;//start MST from vertex 0
			minHeap.add(new Node(0, key[0]));
			
			while(!minHeap.isEmpty()) {
				Node u = minHeap.poll();//remove node with minimum edge weight
				int uVertex = u.dest;
				visited[uVertex]= true;
				//traverse through all adjacent vertices of u(the removed vertex) and update their key value
				for(Node v: adj.get(uVertex)) {
					int vVertex = v.dest;
					int weight = v.weight;
					if(!visited[vVertex] && weight < key[vVertex]) {
						parent[vVertex]= uVertex;
						key[vVertex]= weight;
						minHeap.add(new Node(vVertex, key[vVertex]));
					}
				}
			}
			
			printMST(parent);
		}
		
		void printMST(int[] parent) {
			System.out.println("Edges of minimum spanning tree:");
			for(int i=1;i<V;i++) {
				System.out.println(parent[i] + "---"+i);
			}
		}
		
	}
	public static void main(String[] args) {
		int V = 9;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 8, 2);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);

		graph.primMST();

	}

}
