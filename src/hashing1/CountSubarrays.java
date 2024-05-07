/**
 * 
 */
package hashing1;

import java.util.HashSet;

/**
 * Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number
 * of subarrays of A, that have unique elements.
   Since the number of subarrays could be large, return value % 109 +7.
 *
 */
public class CountSubarrays {

	static int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        long ans = 0;
        int N = A.length, l = 0;
        for(int r = 0; r < N; r++) {
            // check if A[r] is already there in the present window
            while(hs.contains(A[r])) {
                hs.remove(A[l]);
                l++;
            }
            // add the subarrays ending at position r
            ans += r - l + 1;
            hs.add(A[r]);
        }
        return (int)(ans % (long)(1e9 + 7));
    }
	public static void main(String[] args) {
		int[] A = {2,1,2};
		System.out.println(solve(A));

	}

}
