/**
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any 
 * two elements (not necessarily consecutive).Find the minimum number of swaps required to sort the array in ascending order.
 */
package matrix;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwap2 {

	public static int solve(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(A[i], i);
  
        Arrays.sort(A);
  
        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
  
        // Initialize result
        int ans = 0;
        for (int i = 0; i < n; i++) {
  
            // already swapped and corrected or
            // already present at correct pos
            if (visited[i] || map.get(A[i]) == i)
                continue;
  
            int j = i, cycle_size = 0;
            while (!visited[j]) {
                visited[j] = true;
  
                // move to next node
                j = map.get(A[j]);
                cycle_size++;
            }
  
            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3, 2 };
		System.out.println(solve(a));

	}

}
