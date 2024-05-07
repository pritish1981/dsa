/**
 * 
 */
package binarysearch;

import java.util.Arrays;

/**
 * @author Pritish
 *
 */
public class AggressiveCowsProblem {

	static boolean check(int x, int[] A, int c) {
	      int j = 0, n = A.length;
	      int cnt = 1;
	      for (int i = 1; i < n; i++) {
	         if (A[i] - A[j] >= x) {
	            j = i;
	            cnt++;
	         }
	      }
	      return (cnt >= c);
	   }

	   static int solve(int[] A, int B) {
	      int n = A.length;
	      Arrays.sort(A);
	      int l = 1, r = 1000 * 1000 * 1000;
	      int ans = 1;
	      while (l <= r) {
	         int mid = (l + r) / 2;
	         if (check(mid, A, B)) {
	            ans = mid;
	            l = mid + 1;
	         } else {
	            r = mid - 1;
	         }
	      }
	      return ans;
	   }
	public static void main(String[] args) {
		int B = 3;
        int[] A = new int[] { 1, 2, 8, 4, 9 };
       // int N = A.length;
 
        // Function call
        System.out.println(solve(A, B));

	}

}
