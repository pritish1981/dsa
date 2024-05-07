/**
 * 
 */
package heap2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of N elements, where each element is at most K away from its target position.
 *
 */
public class SortNearlyKsortedArray {
/*  Approach:
 *  Create a Min Heap of size K+1 with the first K+1 elements. 
 *  We are creating a heap of size K as the element can be at most K distance from its index in a sorted array. 
    One by one remove the min element from the heap, put it in the result array, and add a new element to the heap from the remaining elements.
 * 
 */
	public static int[] solve(int[] A, int k) {
		int n = A.length;
		//min heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// add first k + 1 items to the min heap
		for (int i = 0; i <= k; i++) { // K
			minHeap.add(A[i]);
		}
		int indx = 0;
		//one by one remove min element from the heap and add a new element to the heap from the remaining elements
		for (int i = k + 1; i < n; i++) { // N-K
			A[indx++] = minHeap.peek();
			minHeap.poll();
			minHeap.offer(A[i]);
		}
		//remove remaining elements from the heap
		while (!minHeap.isEmpty()) {
			A[indx++] = minHeap.peek();
			minHeap.poll();
		}
		return A;
	}

	public static void main(String[] args) {
		int[] A = { 6, 5, 3, 2, 8, 10, 9 };
		int B = 3;
		System.out.println(Arrays.toString(solve(A,B)));
     /*
      * Time Complexity: O(K) + O(N-K)logK), Space Complexity: O(K)
      * 
      */
	}

}
