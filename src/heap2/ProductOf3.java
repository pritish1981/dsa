/**
 * 
 */
package heap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an integer array A of size N.
You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
 *
 */
public class ProductOf3 {

	public static int[] solve(int[] A) {
		// n is the size of the vector
		int n = A.length;
		// Initialize an answer vector
		ArrayList<Integer> ans = new ArrayList<Integer>();
		// Initialize a priority queue
		PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomCompare());
		for (int i = 0; i < n; i++) {
			// Add element in priority queue
			pq.offer(A[i]);
			if (i < 2) {
				ans.add(-1);
			} else {
				// take 3 maximum elements from queue.
				int a = pq.poll();
				int b = pq.poll();
				int c = pq.poll();
				// add all these numbers back to queue
				pq.offer(a);
				pq.offer(b);
				pq.offer(c);
				// append the product to answer
				ans.add(a * b * c);
			}
		}
		
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 10, 2, 13, 4 };
		System.out.println(Arrays.toString(solve(A)));
	}
}

class CustomCompare implements Comparator < Integer > {
	  @Override
	  public int compare(Integer a, Integer b) {
	    return b - a;
	  }
	}

