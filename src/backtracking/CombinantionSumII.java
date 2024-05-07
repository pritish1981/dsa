/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
Each number in A may only be used once in the combination
 *
 */
public class CombinantionSumII {

	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Collections.sort(arr);
		findCombinations(0, arr, target, ans, new ArrayList<>());
		return ans;
	}

	static void findCombinations(int idx, ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
		if (target == 0) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		for (int i = idx; i < arr.size(); i++) {
			if (i > idx && arr.get(i) == arr.get(i - 1))
				continue;
			if (arr.get(i) > target)
				break;

			temp.add(arr.get(i));
			findCombinations(i + 1, arr, target - arr.get(i), ans, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(4);
		arr.add(6);
		arr.add(8);

		int sum = 8;

		ArrayList<ArrayList<Integer>> ans = combinationSum(arr, sum);

		// If result is empty, then
		if (ans.size() == 0) {
			System.out.println("Empty");
			return;
		}

		// print all combinations stored in ans

		for (int i = 0; i < ans.size(); i++) {

			System.out.print("[");
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + ", ");
			}
			System.out.print("] ");
		}
	}

}


