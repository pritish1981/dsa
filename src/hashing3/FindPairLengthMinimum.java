/**
 * 
 */
package hashing3;

import java.util.HashMap;

/**
 * @author Pritish
 *
 */
public class FindPairLengthMinimum {

	static int solve(int[] A) {
		if (A.length == 1) {
			return -1;
		}
		// stores <Value, Index> pair
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = 100000;
		for (int i = 0; i < A.length; i++) {
			// checks if A[i] has occurred previously
			if (map.containsKey(A[i])) {
				result = Math.min(result, i - map.get(A[i]));
			}
			map.put(A[i], i);
		}
		if ( result == 100000) return -1;
		else return result;
	}
	
	public static void main(String[] args) {
		int[] A = {7, 1, 3, 4, 1, 7};
		System.out.println(solve(A));

	}

}
