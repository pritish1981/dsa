/**
 * 
 */
package hashing3;

import java.util.HashSet;

/**
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 *
 */
public class LongestConsecutiveSubsequence {

	/** Solution Approach:
	 * Create an empty hash.
       Insert all array elements to hash.
       Do the following for every element arr[i]
       Check if this element is the starting point of a subsequence. To check this, simply look for arr[i] � 1 in the hash,
       if not found, then this is the first element of a subsequence.
       If this element is the first element, then count the number of elements in the consecutive starting with this element.
       Iterate from arr[i] + 1 till the last element that can be found.
       If the count is more than the previous longest subsequence found, then update this
	 */
	
	//Return the length of the longest consecutive subsequence
	static int solve(int[] A) {
		int n = A.length;
		HashSet<Integer> hs = new HashSet<>();
		int ans = 0;
		// hash all the array elements
		for (int i = 0; i < n; i++) {
			hs.add(A[i]);
		}
		// check each possible subsequence from start & then update optimal length
		for (int i = 0; i < n; i++) {
			// if current element is the starting element of the sequence
			if (!hs.contains(A[i] - 1)) {
				// check for next element in the sequence
				int j = A[i];
				while (hs.contains(j)) {
					hs.remove(Integer.valueOf(j));
					j++;
				}
				// update optimal length if this length is more
				if (ans < j - A[i])
					ans = j - A[i];
			}
		}
		return ans;
	}
  //T.C: O(N), S.C: O(N)

	public static void main(String[] args) {
		int A[] = { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println("Length of the Longest consecutive subsequence is " + solve(A));
	}

}
