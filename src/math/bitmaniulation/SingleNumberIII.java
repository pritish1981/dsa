/**
 * 
 */
package math.bitmaniulation;

import java.util.Arrays;

/**
 * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
   Find the two integers that appear only once.
   Note: Return the two numbers in ascending order.
 *
 */
public class SingleNumberIII {

	public static int[] singleNumber(int[] A) {

		int XOR = 0;
		for (int n : A) {
			XOR ^= n;
		}
		//int lowestBitSet = Integer.lowestOneBit(XOR);
		int rightSetBit =  XOR & -XOR;
		int[] ans = new int[2];
		for (int n : A) {
			if ((n & rightSetBit) == 0)
				ans[0] ^= n;
			else {
				ans[1] ^= n;
			}
		}
        Arrays.sort(ans);
		return ans;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 1, 2, 4};
		int[] ans = singleNumber(A);
		System.out.println(Arrays.toString(ans));
	}

}
