/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there 
 * is a flight from city fromi to city toi with cost pricei.You are also given three integers src, dst, and k, return the cheapest price from src to dst 
 * with at most k stops. If there is no such route, return -1.
 * 
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 *
 *Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 10^4
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst

 */
public class CheapestFlightsWithinKStops {

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		// Create adjacency list to represent the graph
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] route : flights) {
			adj.get(route[0]).add(new Pair(route[1], route[2]));
		}
		// Create queue to perform BFS and initialize distance array
		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(0, src, 0));
		int[] dist = new int[n];
		Arrays.fill(dist, (int) 1e9);
		dist[src] = 0;

		// perform BFS
		while (!q.isEmpty()) {
			Tuple t = q.poll();
			if (t.stops > k)
				continue; // skip nodes that are far away
			for (Pair route : adj.get(t.node)) {
				if (t.stops <= k && t.cost + route.wt < dist[route.node]) {
					// Update distance if it's shorter than the current best distance
					dist[route.node] = t.cost + route.wt;
					// add node to the queue for further process
					q.offer(new Tuple(t.stops + 1, route.node, dist[route.node]));

				}
			}
		}
		// If there is no path to the destination, return -1
		if (dist[dst] == (int) 1e9)
			return -1;
		// Otherwise, return the shortest distance to the destination
		return dist[dst];
	}

	// Helper class to represent a node in the BFS
	static class Tuple {
		int stops; // Number of stops made so far
		int node; // Current node
		int cost; // Total cost so far

		Tuple(int stops, int node, int cost) {
			this.stops = stops;
			this.node = node;
			this.cost = cost;
		}
	}

	// Helper class to represent an edge in the graph
	static class Pair {
		int node; // Destination node
		int wt; // Edge weight

		Pair(int node, int wt) {
			this.node = node;
			this.wt = wt;
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0;
		int dst = 3;
		int k = 1;
		System.out.println(findCheapestPrice(n, flights, src, dst, k));

	}

}
