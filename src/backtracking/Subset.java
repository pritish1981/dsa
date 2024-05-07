/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
 *
 */
public class Subset {

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Collections.sort(A);
		backtrack(list, new ArrayList<>(), A, 0);
		return list;
	}

	private static void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, ArrayList<Integer> A,
			int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < A.size(); i++) {
			if (i > start && A.get(i) == A.get(i - 1))
				continue; // skip duplicates
			tempList.add(A.get(i));
			backtrack(list, tempList, A, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		System.out.println(subsets(A));

	}

}
