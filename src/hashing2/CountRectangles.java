/**
 * 
 */
package hashing2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l])
form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
 *
 */
public class CountRectangles {

	static int solve(int[] A, int[] B) {
		int n = A.length;
		HashMap<Integer, HashSet<Integer>> mpx = new HashMap<>();
		HashSet<Integer> h;
		for(int i = 0;i<n;i++) {
			if(mpx.containsKey(A[i]))
				h = mpx.get(A[i]);
			else
				h = new HashSet<>();
			h.add(B[i]);
			mpx.put(A[i], h);
			
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j = i+1;j<n;j++) {
				// // checks if there exists a rectangle such that the i-th and j-th points are the ends of a diagonal
				if(A[i] ==A[j] || B[i] == B[j])
					continue;
				if(mpx.get(A[i]).contains(B[j]) && mpx.get(A[j]).contains(B[i]))
					ans++;
			}
		}
		return ans/2;
	}
	public static void main(String[] args) {
		int[] A = {1, 1, 2, 2, 3, 3};
		int[] B = {1, 2, 1, 2, 1, 2};
		System.out.println(solve(A,B));

	}

}
