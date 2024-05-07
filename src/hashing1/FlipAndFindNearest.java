/**
 * 
 */
package hashing1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Given a binary string A of size N. There are Q queries given by the array B of size Q*2.
Each query has 2 integers :-
First integer denotes the type of query. Type of query can be either 1 or 2.
Second integer denotes index x.
If type = 1, flip the value at index x.
If type = 2, find the index of nearest 1 from index x. If there are multiple indices, return the one with lower value.
If there is no such index, return -1.
Note :- We use 1-based indexing

Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= B[i][0] <= 2
1 <= B[i][1] <= N

Input Format:
First argument A is a string.
Second argument B is a 2D array of integers describing the queries.

Output Format:
Return an array of integers denoting the answers to each query of type 2.
 *
 */
public class FlipAndFindNearest {

	/**
	 * @param args
	 */
	static int[] solve(String A, int[][] B) {
		final int inf = (int) (1e9);
		TreeSet<Integer> set = new TreeSet<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		// set stores the index of all '1's
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '1') {
				set.add(i + 1);
			}
		}
		for (int i = 0; i < B.length; i++) {
			int type = B[i][0];
			int x = B[i][1];
			if (type == 1) {
				if (set.contains(x)) {
					// flip the bit from '1' to '0'
					set.remove(x);
				} else {
					// flip the bit from '0' to '1'
					set.add(x);
				}
			} else {
				int left = -inf, right = inf;
				if (set.ceiling(x) != null) {
					// finds the nearest '1' on the right
					right = set.ceiling(x);
				}
				if (set.floor(x) != null) {
					// finds the nearest '1' on the left
					left = set.floor(x);
				}
				if (left == -inf && right == inf) {
					ans.add(-1);
				} else if (x - left <= right - x) {
					ans.add(left);
				} else {
					ans.add(right);
				}
			}
		}
		return ans.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		String A = "10010";
		int[][] B = {{1,2},
				     {2,3}};
		int[] ans = solve(A,B);
		System.out.println(Arrays.toString(ans));

	}

}
