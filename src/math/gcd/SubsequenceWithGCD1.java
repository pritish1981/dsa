/**
 * 
 */
package math.gcd;

/**
 * Given an array, check if there is a subsequence with GCD = 1;
 * Idea:if there is a subsequence of gcd = 1, gcd of array = 1;
 */
public class SubsequenceWithGCD1 {

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
	
	static boolean check_gcd_one(int[] arr) {
		int gcd_of_array = gcdOfArray(arr);
		if(gcd_of_array == 1) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		int[] a = {4,6,3,8};
        System.out.println(check_gcd_one(a));
	}

}
