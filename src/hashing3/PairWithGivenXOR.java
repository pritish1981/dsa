/**
 * 
 */
package hashing3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given an integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
 *
 */
public class PairWithGivenXOR {

	 public static int solve(ArrayList<Integer> A, int B) {
	        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
	        int ans = 0;
	        for(int x: A){
	            if(mp.containsKey(x^B)){
	                ++ans;
	            }
	            mp.put(x, 1);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(3);
		A.add(6);
		A.add(8);
		A.add(10);
		A.add(15);
		int B = 5;
		//(3 ^ 6) = 5 and (10 ^ 15) = 5 
		System.out.println(solve(A,B));

	}

}
