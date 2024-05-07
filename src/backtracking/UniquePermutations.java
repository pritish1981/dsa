/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II:
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * Example 1:

Input: nums = [1,1,2]
Output: [[1,1,2], [1,2,1], [2,1,1]]
 */
public class UniquePermutations {

	public static List<List<Integer>> uniquePermute(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>(); // ans list
		Arrays.sort(nums); // sort the array

		// create a boolean array which track the certain indexed integer is present in
		// out temp list or not
		helper(ans, new ArrayList<>(), nums, new boolean[nums.length]); // helper method

		return ans; // return output
	}

	private static void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {

		/*
		 * when size of the temp list and size of the inout array are same then add this
		 * temp list into the final ans list. this is one of our permutation for given
		 * integer array
		 */
		if (nums.length == temp.size()) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		/*
		 * Traverse for whole array one by one.
		 */
		for (int i = 0; i < nums.length; i++) {

			if (vis[i])
				continue; // if current element is already present in the temp, skip the element
			if (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])
				continue; // if prev element and current element is equal, skip the element

			vis[i] = true;
			temp.add(nums[i]);

			helper(ans, temp, nums, vis); // recursive call

			// backtracking
			temp.remove(temp.size() - 1);
			vis[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 2 };
		System.out.println(uniquePermute(A));

	}

}
