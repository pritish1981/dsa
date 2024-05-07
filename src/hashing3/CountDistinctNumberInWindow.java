/**
 * 
 */
package hashing3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers
 *  in all windows of size B.Formally, return an array of size N-B+1 where i'th element in this array contains number 
 *  of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.NOTE: if B > N, return an empty array.
 *
 */
public class CountDistinctNumberInWindow {

	public static ArrayList<Integer> countDistinct(ArrayList<Integer>A, int B) {
		int n = A.size();
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		// Traverse the first window and store count of every element in hash map
		for(int i=0;i<n;i++) {
			if(hm.containsKey(A.get(i))) {
				hm.put(A.get(i), hm.get(A.get(i)+1));
			}else {
				hm.put(A.get(i), 1);
			}
			if(i-B+1 >= 0) {
				//decrease key
				result.add(hm.size());
				hm.put(A.get(i-B+1),hm.get(A.get(i-B+1))-1);
				//remove if count becomes zero
				if(hm.get(i-B+1) == 0) {
					hm.remove(A.get(i-B+1));
				}
			}
			
		}
		return result;
	}
   
	public static void main(String[] args) {
		//int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int K = 4;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(2);a.add(1);a.add(3);a.add(4);a.add(2);a.add(3);
 
        // Function call
        countDistinct(a, K);
	}

}
