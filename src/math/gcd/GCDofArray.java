/**
 * 
 */
package math.gcd;

/**
 * Given an array of numbers, find GCD of the array elements.
 *
 */
public class GCDofArray {

	static int getGCD(int a, int b) {
		while (a > 0 && b > 0) {
			if (a > b) {
				a = a % b;
			} else {
				b = b % a;
			}
		}
		if (a == 0)
			return b;
		else
			return a;
	}

	static int gcdOfArray(int[] arr) {
		int n = arr.length;
		int gcd = 0;
		for (int i = 0; i < n; i++) {
			gcd = getGCD(gcd, arr[i]);
		}
		return gcd;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8 };
		System.out.println(gcdOfArray(arr));
	}

}
