/**
 * 
 */
package stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Pritish
 *
 */
public class NearestGreaterElementOnLeft {

	static int[] ngl(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			// pop all smaller and equal elements
			while (!st.empty() && st.peek() <= A[i]) {
				st.pop();
			}
			// update ans
			if (st.empty())
				ans[i] = -1;
			else {
				ans[i] = st.peek();
			}
			// push current element
			st.push(A[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 2,1,4,3};
		int[] ans = ngl(A);
		System.out.println(Arrays.toString(ans));

	}
}
