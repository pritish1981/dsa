/**
 * 
 */
package heap2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Sort the array using max-heap
 *
 */
public class HeapSort {

	/**
	 * Approach:
	 * 1.Convert the input array into a max heap using the STL priority queue.
       2.Remove the top element of the max heap and place it at the end of the array.
       3.Repeat step 2 for all the remaining elements in a heap.
	 */
	
	public static void heapSort(int[] arr) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			maxHeap.offer(arr[i]);
		}
		for(int i = arr.length-1;i>=0;i--) {
			arr[i] = maxHeap.poll();
		}
	}

	public static void main(String[] args) {
		int[] arr = { 60, 20, 40, 70, 30, 10 };
		System.out.println("Before Sorting: " + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("After Sorting: " + Arrays.toString(arr));
	}

}
