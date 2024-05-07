/**
 * 
 */
package heap1;

import java.util.PriorityQueue;

/**
 * You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Approach:
1.Declare a priority queue and push all the elements in it.
2.Do following while the number of elements in min-heap is greater than one. 
3.Extract the minimum and second minimum from min-heap
4.Add the above two extracted values and insert the added value to the min-heap.
5.Maintain a variable for total cost and keep incrementing it by the sum of extracted values.
6.Return the value of total cost.
 *
 */
public class ConnectingRopes {

	static int minCost(int[] A) {
		int n = A.length;
		//creating a priority queue
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//add items to the queue
		for(int i=0;i<n;i++) {
			pq.add(A[i]);
		}
		int res = 0;
		//while size of the priorityqueue > 1
		while(pq.size() > 1) {
			//extract shortest two ropes from pq
			int first = pq.poll();
			int second = pq.poll();
			//connect ropes: update result & insert new rope to pq
			res += first + second;
			pq.add(first + second);
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		int A[] = { 4, 3, 2, 6 };
		System.out.println("Total cost for connecting ropes is "
                + minCost(A));

	}

}
