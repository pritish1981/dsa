/**
 * 
 */
package binarysearch;

/**
 * @author Pritish
 *
 */
public class FindAthMagicalNumber {

	static int athMagicalNumber(int A, int B, int C) {
		long B1 = B, C1 = C;
		long mod = (long) (Math.pow(10, 9) + 7);
		long left = Math.min(B, C);
		long right = (long) A * Math.min(B, C);

		// Finding GCD
		while (C1 > 0) {
			long tmp = B1;
			B1 = C1;
			C1 = tmp % C1;
		}

		long lcm = (B * C) / B1; // (n1*n2)/GCD

		while (left < right) {
			long m = left + (right - left) / 2;

			if ((m / B) + (m / C) - (m / lcm) < A)
				left = m + 1;
			else
				right = m;
		}
		return (int) (left % mod);
	}

	public static void main(String[] args) {
		int A = 4, B = 2, C = 3;
		System.out.println("Ath magical number is: "+athMagicalNumber(A,B,C));

	}

}
