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
public class NearestGreaterElementOnRight {

	static int[] ngr(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			// pop all smaller and equal elements
			while (!st.isEmpty() && st.peek() <= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
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
		int[] A = {4, 5, 2, 10, 8};
		int[] ans = ngr(A);
		System.out.println(Arrays.toString(ans));

	}

}
