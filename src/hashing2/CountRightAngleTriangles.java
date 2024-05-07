/**
 * 
 */
package hashing2;

import java.util.HashMap;

/**
 * @author Pritish
 *
 */
public class CountRightAngleTriangles {

	static int solve(int[] A, int[] B) {
		int n = A.length;
		HashMap<Integer, Integer> mpx = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mpy = new HashMap<Integer, Integer>();
		for(int i = 0;i<n;i++) {
			if(mpx.get(A[i]) == null) {
				mpx.put(A[i], 1);
			}else {
				mpx.put(A[i], mpx.get(A[i]) + 1);
			}
			if(mpy.get(B[i]) == null) {
				mpy.put(B[i], 1);
			}else {
				mpy.put(B[i], mpy.get(B[i]) + 1);
			}
		}
		long ans = 0,mod = 1000 *1000 * 1000 + 7;
		for(int i=0;i<n;i++) {
			//count the no of triangles that forms a right angle at ith point
			ans += ((mpx.get(A[i]) - 1) * (mpy.get(B[i]) - 1))% mod;
		}
		return (int)ans;
	}
	public static void main(String[] args) {
		int[] A = {1, 1, 2, 3, 3};
		int[] B = {1, 2, 1, 2, 1};
		System.out.println(solve(A,B));

	}

}
