/**
 * 
 */
package backtracking;

import java.util.ArrayList;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {

	public static ArrayList<ArrayList<Integer>> permute(int[] A) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null || A.length <= 0)
			return result;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean[] used = new boolean[A.length];
		for (int i = 0; i < used.length; i++)
			used[i] = false;
		helper(result, ans, A, used, A.length);
		return result;
	}

	public static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ans, int[] num, boolean[] used,int n) {
		if (n == 0) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for (int i = 0; i < ans.size(); i++)
				cur.add(ans.get(i));
			result.add(cur);
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if (used[i] == false) {
				used[i] = true;
				ans.add(num[i]);
				helper(result, ans, num, used, n - 1);
				ans.remove(ans.size() - 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		System.out.println(permute(A));

	}

}
