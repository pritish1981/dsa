/**
 * 
 */
package math.gcd;

/**
 * Remove an element to maximize the GCD of the given array
 * Example:
 * Input: arr[] = {12, 15, 18} ,Output: 6 
  Remove 12: GCD(15, 18) = 3 
  Remove 15: GCD(12, 18) = 6 
  Remove 18: GCD(12, 15) = 3
 */
/*Approach:  
Idea is to find the GCD value of all the sub-sequences of length (N – 1) and removing the element which is not present
in the sub-sequence with that GCD. The maximum GCD found would be the answer.
To find the GCD of the sub-sequences optimally, maintain a prefixGCD[] and a suffixGCD[] array using single state dynamic programming.
The maximum value of GCD(prefixGCD[i – 1], suffixGCD[i + 1]) is the required answer.
 */
public class MaxGCD {
	static int gcd(int a, int b) {
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
	
	static int maxGCD(int[] arr) {
		int n = arr.length;
		//prefix & suffix array
		int prefix[] = new int[n+2];
		int suffix[] = new int[n+2];
		//Single state dynamic programming relation for storing gcd of first i elements from the left in prefix[i]
		prefix[1] = arr[0];
		for(int i=2;i<=n;i++) {
			prefix[i] = gcd(prefix[i-1], arr[i-1]);
		}
		//initializing suffix array
		suffix[n] = arr[n-1];
		for(int i = n-1;i>=1;i--) {
			suffix[i] = gcd(suffix[i+1], arr[i-1]);
		}
		//if 1st or last element of the array has to be removed
		int ans = Math.max(suffix[2], prefix[n-1]);
		//if any other element is removed from the array
		for(int i=2;i<n;i++) {
			ans = Math.max(ans, gcd(prefix[i-1],suffix[i+1]));
		}
		return ans;
		
		//T.C : O(n log M) where M is the maximum element from the array.
		//S.c: O(n)
		
	}
	
	public static void main(String[] args) {
		int a[] = { 14, 17, 28, 70 };
		System.out.println(maxGCD(a));

	}

}
