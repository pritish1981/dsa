/**
 * 
 */
package hashing3;

import java.util.HashMap;

/**
 * Find length of longest sub-array zero sum.
 *
 */
public class LongestSubArrayZeroSum {
		
	public static int longestSubArrayWithZeroSum(int[] A) {
		int n = A.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0, maxLength = 0;
		for (int i = 0; i < n; i++) {
			sum += A[i]; //update the value of sum
			if (sum == 0)
				maxLength = i + 1;
			//Check every index, if the current sum is present in the hash map or not.
			//If present, update the value of max_len to a maximum difference of two indices (current index and index in the hash-map) and max_len.
			else if (hm.containsKey(sum)) {
				maxLength = Math.max(maxLength, i - hm.get(sum));
			} else {//put the value (sum) in the hash map
				hm.put(sum, i);
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int[] A = {15, -2, 2, -8, 1, 7, 10, 23};
		System.out.println("Length of longest sub-array with zero sum::"+longestSubArrayWithZeroSum(A));
		
	}

}
