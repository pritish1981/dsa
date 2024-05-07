/**
 * 
 */
package heap2;

import java.util.PriorityQueue;

/**
 * @author Pritish
 *
 */
public class FindKthLargestElement {

	/**
	 * Solution Approach:
	 * We can easily solve this problem in O(n.log(k)) by using a min-heap. 
	 * The idea is to construct a min-heap of size k and insert the first k elements of array A[0�k-1] into the min-heap.
	 *  Then for each of the remaining array elements A[k�n-1], if that element is more than the min-heap�s root, 
	 *  replace the root with the current element. Repeat this process until the array is exhausted. Now we will be 
	 *  left with top k largest array elements in the min-heap, and k'th largest element will reside at the root of the min-heap.
	 */
	public static int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
		}
		while (pq.size() > k) {
			pq.remove();
		}
		return pq.peek();

	}
	public static void main(String[] args) {
		int arr[] = { 8,5,2,4,9,7 };
		int k = 3;
		System.out.println(findKthLargest(arr,k));

	}

}
