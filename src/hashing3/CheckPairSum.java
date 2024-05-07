/**
 * 
 */
package hashing3;

import java.util.HashSet;

/**
 * Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 *
 */
public class CheckPairSum {

	public static int solve(int A, int[] B) {
        int n = B.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            int x = B[i];
            int y = A - x;
            if(hs.contains(y)){
                return 1;
            }else{
                hs.add(x);
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		int[] B = {3, 5, 1, 2, 1, 2};
		int A = 8;
		solve(A,B);
		System.out.println(solve(A,B));

	}

}
