/**
 * 
 */
package heap2;

import java.util.Collections;
import java.util.PriorityQueue;

/** Find median from the data stream
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 */


public class MedianFinder {
	// method to calculate med of stream
    public static void printMedian(int[] a)
	{
		double med = a[0];
		// max heap to store the smaller half elements
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
		// min-heap to store the greater half elements
		PriorityQueue<Integer> greater = new PriorityQueue<>();
		smaller.add(a[0]);
		System.out.println(med);

		// reading elements of stream one by one
		/*
		 * At any time we try to make heaps balanced and their sizes differ by at-most
		 * 1. If heaps are balanced,then we declare median as average of
		 * min_heap_right.top() and max_heap_left.top() If heaps are unbalanced,then
		 * median is defined as the top element of heap of larger size
		 */
		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			// case1(left side heap has more elements)
			if (smaller.size() > greater.size()) {
				if (x < med) {
					greater.add(smaller.remove());
					smaller.add(x);
				} else
					greater.add(x);
				med = (double) (smaller.peek() + greater.peek()) / 2;
			}
			// case2(both heaps are balanced)
			else if (smaller.size() == greater.size()) {
				if (x < med) {
					smaller.add(x);
					med = (double) smaller.peek();
				} else {
					greater.add(x);
					med = (double) greater.peek();
				}
			}
			// case3(right side heap has more elements)
			else {
				if (x > med) {
					smaller.add(greater.remove());
					greater.add(x);
				} else
					smaller.add(x);
				med = (double) (smaller.peek() + greater.peek()) / 2;
			}
			System.out.println(med);
		}
	}
	    
	public static void main(String[] args) {
		
		// stream of integers
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
       /* Time Complexity: O(n Log n). 
        Time Complexity to insert element in min heap is log n. So to insert n element is O( n log n).
        Auxiliary Space : O(n). */
	}

}
