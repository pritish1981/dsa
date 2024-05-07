/**
 * 
 */
package tct1;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given an integer array, remove all repeating subsequences from the array. A subsequence is considered repeating if it occurs more than once consecutively in the array.
Examples:

Input: {4, 5, 6, 7, 8, 6, 7, 8, 6, 7, 8}
Output: {4, 5, 6, 7, 8}
Explanation: After a particular point, the subsequence 6, 7, 8 starts repeating.

Input: {1, 2, 3, 2, 3, 4, 2, 3, 4, 5}
Output: {1, 2, 3, 4, 5}
Explanation: After a particular point, the subsequence 2, 3, 4 starts repeating.

 *
 */
public class RemoveAllRepeatingSubsequenceFromArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 3, 5, 2 };
		int[] result = removeRepeatingSubsequences(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ",");
		}
	}

	public static int[] removeRepeatingSubsequences(int[] arr) {
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int[] result = new int[set.size()];
		int i = 0;
		for (int num : set) {
			result[i++] = num;
		}
		return result;
	}
}
