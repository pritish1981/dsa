/**
 * 
 */
package hashing1;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given two arrays of integers A and B, Sort A in such a way that the relative order among the 
 * elements will be the same as those are in B.
  For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
 *
 */
public class SortArrayInOrder {

	static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
		// stores the frequency of the elements of A
		for (int i = 0; i < A.size(); i++) {
			int x = A.get(i);
			if (mp.get(x) == null) {
				mp.put(x, 1);
			} else {
				mp.put(x, mp.get(x) + 1);
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < B.size(); i++) {
			int y = B.get(i);
			// checks if y exists in A
			if (mp.get(y) != null) {
				while (mp.get(y) > 0) {
					ans.add(y);
					mp.put(y, mp.get(y) - 1);
				}
			}
		}
		Set<Integer> keys = mp.keySet();
		// append the elements that are not present in B
		for (Integer key : keys) {
			int t = mp.get(key);
			while (t > 0) {
				ans.add(key);
				t--;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1); a.add(2); a.add(3); a.add(4); a.add(5);
		
		ArrayList<Integer> b = new ArrayList<>();
		b.add(5); b.add(4); b.add(2);
		
		System.out.println(solve(a,b));

	}

}
