/**
 * 
 */
package stacks;
import java.util.Stack;

/**Stack-2 assignment # 3
 * Find sum of  Max-Min for all sub arrays
 */
public class MaxMinSubArray {
	public static int mod = (int)1e9+7;
	static int solve(int[] A) {
		int n = A.length;
		int nsl[] = new int[n];
		int nsr[] = new int[n];
		int ngl[] = new int[n];
		int ngr[] = new int[n];
		Stack<Integer> st = new Stack<>();
		// nearest smaller elements on left
		for (int i = 0; i < n; i++) {
			// pop all greater and equal elements
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				nsl[i] = -1;
			else {
				nsl[i] = st.peek();
			}
			// push current element
			st.push(i);
		}
		// nearest smaller elements on right
		st = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			// pop all greater and equal elements
			while (!st.isEmpty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				nsr[i] = n;
			else {
				nsr[i] = st.peek();
			}
			// push current element
			st.push(i);
		}
		// find nearest greater elements on left
		st = new Stack<>();
		for (int i = 0; i < n; i++) {
			// pop all smaller and equal elements
			while (!st.isEmpty() && A[st.peek()] <= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				ngl[i] = -1;
			else {
				ngl[i] = st.peek();
			}
			// push current element
			st.push(i);
		}

		// find nearest greater elements on right
		st = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			// pop all smaller and equal elements
			while (!st.isEmpty() && A[st.peek()] <= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				ngr[i] = n;
			else {
				ngr[i] = st.peek();
			}
			// push current element
			st.push(i);
		}
		long max = 0, min = 0;
		for(int i=0;i<n;i++) {
			max += (((A[i] % mod) * (i - ngr[i]) % mod) * ((ngl[i] - i) % mod)%mod);
			min += (((A[i] % mod) * (i - nsr[i]) % mod) * ((nsl[i] - i) % mod)%mod);
		}
		
		return (int)(max - min) % mod;
	}
	public static void main(String[] args) {
		int[] A = {4,7,3,8};
		int ans = solve(A);
		System.out.println(ans);
		//Output: 26
	}

}
