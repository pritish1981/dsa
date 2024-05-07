/**
 * 
 */
package heap1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find k largest element in an array
 *
 */
class Pair {
    int ff;
    int ss;
    public Pair(int c, int d) {
        this.ff = c;
        this.ss = d;
    }
}
class CustomComp implements Comparator < Pair > {
    @Override
    public int compare(Pair a, Pair b) {
        return a.ff - b.ff;
    }
}
public class MinimumLargestElement {

	public static int solve(int[] A, int B) {
		PriorityQueue<Pair> pq = new PriorityQueue(new CustomComp());
		int n = A.length;
		// Let's keep a state array to keep track of the value of every element in the
		// array after K operations.
		// Initially state array will be the same as the inital array.
		int[] state = new int[n];
		for (int i = 0; i < n; i++) {
			state[i] = A[i];
		}
		// Consider a min heap. And initially push the next state of every element in
		// the heap.
		// Note that you need to keep track of the indices of every element in the heap,
		// present in the initial array.
		for (int i = 0; i < n; i++) {
			pq.offer(new Pair(2 * A[i], i));
		}
		while (B-- > 0) {
			Pair top = pq.poll();
			// Pick the top element, and change the state of that element, in the state array.
			state[top.ss] = top.ff;
			pq.offer(new Pair(A[top.ss] + top.ff, top.ss));
		}
		int mx = state[0];
		for (int i = 0; i < n; i++)
			mx = Math.max(mx, state[i]);
		return mx;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int	 B = 3;
		System.out.println(solve(A,B));

	}

}
