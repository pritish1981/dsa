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
public class NearestSmallerElementOnRight {

	static int[] nsr(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			// pop all greater and equal elements
			while (!st.empty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				ans[i] = -1;
			else {
				ans[i] = st.peek();
			}
			// push current element
			st.push(i);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] A = {2,1,4,3};
		int[] ans = nsr(A);
		System.out.println(Arrays.toString(ans));
		
		/*Input: [2 1 4 3]
		  Output: [1 -1  3 -1]
		*/
	}

}
