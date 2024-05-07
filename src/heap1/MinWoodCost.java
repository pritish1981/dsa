/**
 * 
 */
package heap1;

import java.util.PriorityQueue;

/**
 * In a Carpantry shop there are N wooden boards of various lengths,You are given an Integer Array A of length N, where A[i]
 * represents the length of the i-th board.You can join any two boards of length x & y into one board by paying a cost of x+y.
 * You must join all the boards until there is only one board remaining. Return the minimum cost of joining all the given boards 
 * into one board.
 * 
 * Constraints:
 * 1<= A.length <= 10^6
 * 1<=A[i]<= 10^9
 */
public class MinWoodCost {

	static long minWoodCost(int[] arr) {
		int n = arr.length;
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for(int i=0;i<n;i++) {
			pq.add((long) arr[i]);
		}
		long cost = 0;
		while(pq.size() > 1) {
			long first = pq.poll();
			long second = pq.poll();
			cost += first + second;
			pq.add(first + second);
		}
		return cost;
	}
	//Time Complexity: O(N log N), S.C: O(N)
	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 6 };
		System.out.println(minWoodCost(arr));

	}

}
