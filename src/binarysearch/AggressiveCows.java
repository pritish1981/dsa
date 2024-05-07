/**
 * 
 */
package binarysearch;

import java.util.Arrays;

/**
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall
 * and an integer B which represents the number of cows.His cows don't like this barn layout and become aggressive towards each other once put into a stall.
 * To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large
 * as possible. What is the largest minimum distance?
 *
 *Constraints: 
 *  2 <= N <= 100000
    0 <= A[i] <= 109
    2 <= B <= N
 *Input Format :
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format :
Return the largest minimum distance possible among the cows.
 */
public class AggressiveCows {

	static int solve(int[] A, int B) {
	      Arrays.sort(A);
	      int l = 1, r = 1000 * 1000 * 1000;
	      int ans = 1;
	      while (l <= r) {
	         int mid = (l + r) / 2;
	         if (check(mid, A, B)) {
	            ans = mid;
	            l = mid + 1;
	         } else {
	            r = mid - 1;
	         }
	      }
	      return ans;
	   }
	
	// Function to check if it is possible to position the cow x distance apart
	static boolean check(int x, int[] A, int c) {
	      int n = A.length;
	      int cnt = 1;
	      int d = A[0];
	      for (int i = 1; i < n; i++) {
	         if (A[i] - d >= x) {
	            d = A[i];
	            cnt++;
	         }
	      }
	      return (cnt >= c);
	   }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		int B = 3;
		System.out.println(solve(A,B));

	}

}
