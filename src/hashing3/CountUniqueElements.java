/**
 * 
 */
package hashing3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pritish
 *
 */
public class CountUniqueElements {

	 public static int solve(int[] A) {
	        Map<Integer, Integer> freq = new HashMap<>();
	        for(int i = 0 ; i < A.length ; i++){
	            if(freq.containsKey(A[i])){
	                freq.put(A[i], freq.get(A[i]) + 1);
	            } 
	            else{
	                freq.put(A[i], 1);
	            }
	        }
	        int count = 0;
	        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
	            if(entry.getValue() == 1){
	                count++;
	            }
	        }
	        return count;
	    }
	public static void main(String[] args) {
		int[] A = {3, 4, 3, 6, 6};
         solve(A);
         System.out.println(solve(A));
	}

}
