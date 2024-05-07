/**
 * 
 */
package tct2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * 
 * Approach:
 * 1.Create a HashMap to store the frequency of each element.
   2.Create a PriorityQueue to sort the elements based on their frequencies.
   3.Add all elements to the PriorityQueue.
   4.Create a list to store the top k frequent elements.
   5.Iterate over the PriorityQueue and add the top k elements to the list.
 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		//output : [1,2]
		int[] ans = topKFrequent(nums, k);
		System.out.println("Top K frequent elements in array are:: " + Arrays.toString(ans));

	}
	public static int[] topKFrequent(int[] nums, int k) {
		//create a hashmap to store frequency of each element
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int num : nums) {
			if(hm.containsKey(num)) {
				hm.put(num, hm.getOrDefault(num, 0) + 1);//if it contains add default 1
			}else {
				hm.put(num, 1); // else 1
			}
		}
		//create a priority queue to sort the elements based on their frequencies
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));
		//add elements to the priority queue
		pq.addAll(hm.keySet());//by using keyset we can add all elements without for loop
		// Create a list to store the top k frequent elements
		int[] topFrequentElements = new int[k];
		int m = 0;
		while(k > 0) {
			topFrequentElements[m++] = pq.poll();
			k--;
		}
		return topFrequentElements;
	}
	
	//Time Complexity: O(n log n) as we are sorting elements using priority queue,
	//Space Complexity: O(n) as we have to store hashmap & priority queue
}
