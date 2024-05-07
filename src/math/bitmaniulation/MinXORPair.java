/**
 * 
 */
package math.bitmaniulation;

import java.util.Arrays;

/**
 * @author Pritish
 *
 */
public class MinXORPair {

	static int minXOR(int A[])
    {
		int n = A.length;
        // Sort given array
        Arrays.sort(A);
 
        int minXor = Integer.MAX_VALUE;
        int val = 0;
 
        // calculate min xor of consecutive pairs
        for (int i = 0; i < n - 1; i++) {
            val = A[i] ^ A[i + 1];
            minXor = Math.min(minXor, val);
        }
 
        return minXor;
    }
	public static void main(String[] args) {
		int arr[] = { 9, 5, 3 };
        int n = arr.length;
        System.out.println(minXOR(arr));

	}

}
