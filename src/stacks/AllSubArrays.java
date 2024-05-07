/**
 * 
 */
package stacks;

import java.util.Stack;

/**
 * Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
Find and return the maximum value of XOR among all subarrays.
 *
 */
public class AllSubArrays {

	public static int solve(int[] A) {
        int ans = 0;
        int n = A.length;
        // create a stack to store the maximum value of all subarrays
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = 0; i < n; i++) {
            // while stack is not emepty take xor of its top and current element
            while (!s.empty()) {
                // strore the maximum value of xor
                int topElement = s.peek();
                ans = Math.max(ans, (A[topElement] ^ A[i]));
                // if top of the stack is greater than current element than break the loop
                if (A[topElement] > A[i]) break;
                else s.pop(); //pop out the top of the stack
            }
            // push the current element into the stack
            s.push(i);
        }
        // return the answer
        return ans;
    }
	public static void main(String[] args) {
		int[] A = {2, 3, 1, 4};
        System.out.println(solve(A));
	}

}
