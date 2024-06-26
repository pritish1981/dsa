/**
 * 
 */
package hashing3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pritish
 *
 */
public class CountDistinctNum {

	 public static  ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
	        int n = A.size();
	        ArrayList<Integer> ret = new ArrayList<>();
	        Map<Integer, Integer> m = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            // Increase key
	            if (m.containsKey(A.get(i))) {
	                m.put(A.get(i), m.get(A.get(i)) + 1);
	            } else {
	                m.put(A.get(i), 1);
	            }
	            if (i - B + 1 >= 0) {
	                // Decrease key
	                ret.add(m.size());
	                m.put(A.get(i - B + 1), m.get(A.get(i - B + 1)) - 1);
	                // Remove if count becomes 0
	                if (m.get(A.get(i - B + 1)) == 0) {
	                    m.remove(A.get(i - B + 1));
	                }
	            }
	        }
	        return ret;
	    }
	

}
