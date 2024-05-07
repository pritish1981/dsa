/**
 * 
 */
package graphs;

import java.util.Arrays;

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
 *
 */
public class CheapestFlightWithKStops {

	/**
	 * Bellman Ford Algorithm: As in bellman ford, in the i'th iteration we would surely have found the best path of i distance, but in some cases i'th iteration can result 
	 * in answer of (i + 1, i + 2 or n) length path, this is because of arrangement of edges.So, if we use the prev iteration array for checking the weight is smaller 
	 * or not and updating in current array, we can easily overcome this situation.
	 */
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] prev = new int[n];
		Arrays.fill(prev, Integer.MAX_VALUE); // initialize distance to other vertices as infinity
		prev[src] = 0; // distance from src to src is 0
		for (int i = 0; i <= k; i++) {
			int[] curr = new int[n];
			for (int j = 0; j < n; j++) {
				curr[j] = prev[j];
			}
			for (int[] flight : flights) {
				int from = flight[0];
				int to = flight[1];
				int price = flight[2];
				if (prev[from] != Integer.MAX_VALUE && prev[from] + price < curr[to]) {
					curr[to] = prev[from] + price;
				}
			}
			for (int j = 0; j < n; j++) {
				prev[j] = curr[j];
			}
		}

		return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];

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
