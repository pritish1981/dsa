/**
 * 
 */
package heap1;

import java.util.PriorityQueue;

/**
 * Misha loves eating candies. She has been given N boxes of Candies.
She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box
that has the minimum number of candies.Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. 
Can you find how many candies she will eat?
NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
NOTE 2: The same box will not be chosen again.
 *
 */
public class MishaAndCandies {

	static int solve(int[] A, int B) {
		int candies_ate = 0;
		// create a priority_queue to get box with minimum candies in O(1);
		PriorityQueue<Integer> pq = new PriorityQueue();
		// put all elements in priority queue
		for (int i : A)
			pq.offer(i);
		while (pq.size() > 0) {
			int curr_box = pq.poll(); // take out box with minimum candies
			if (curr_box > B)
				break;
			candies_ate += (curr_box / 2); // eat half of the candies
			if (pq.size() == 0)
				break;
			int next_box = pq.poll() + (int) Math.ceil(curr_box / 2.0); // push remaining half candies into next box
			if (next_box <= B)
				pq.offer(next_box);//insert in next box
		}
		// return candies she can eat.
		return candies_ate;
	}
	
	public static void main(String[] args) {
		int[] A = {3, 2, 3};
		int	 B = 4;
		System.out.println(solve(A,B));
	}

}
