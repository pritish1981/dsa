
package graphs;

/**
 * Floyd Warshall's Algorithm is used for solving all pair shortest path problems.
 * Floyd-Warshall algorithm is an ideal choice for finding the length of the shortest path across every pair of nodes in a graph data structure.But it shouldn't contains
 * negative weight cycle.
 *
 */
public class FloydWarshallAlgorithm {

	   final static int INF = 99999, V = 4;
	 
		public static void floydWarshall(int graph[][]) {
			// Time: O(V^3), Space: O(1)

			for (int k = 0; k < V; k++) {
				for (int i = 0; i < V; i++) {
					for (int j = 0; j < V; j++) {
						if (graph[i][k] != INF && graph[k][j] != INF) {
							if (graph[i][j] == INF) {
								graph[i][j] = graph[i][k] + graph[k][j];
							} else {
								graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
							}
						}
					}
				}
			}
			printSolution(graph);
		}

		static void printSolution(int graph[][]) {
			System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (graph[i][j] == INF)
						System.out.print("INF ");
					else
						System.out.print(graph[i][j] + "   ");
				}
				System.out.println();
			}
		}
	 
	public static void main(String[] args) {
		
		int graph[][] = { { 0, 5, INF, 10 },
                          { INF, 0, 3, INF },
                          { INF, INF, 0, 1 },
                          { INF, INF, INF, 0 } };
		
				
		FloydWarshallAlgorithm fa = new FloydWarshallAlgorithm();
		fa.floydWarshall(graph);
     
    
	}

}
