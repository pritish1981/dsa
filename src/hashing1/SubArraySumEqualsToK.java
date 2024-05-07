/**
 * 
 */
package hashing1;

import java.util.HashMap;

/**
 * iven an array of integers A and an integer B.
 *
 * Find the total number of subarrays having sum equals to B.
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * Output Format
 *
 * Return the total number of subarrays having sum equals to B.
 * Constraints
 *
 * 1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 * For Example
 *
 * Input 1:
 *     A = [1, 0, 1]
 *     B = 1
 * Output 1:
 *     4
 *     Explanation 1:
 *         [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
 *
 * Input 2:
 *     A = [0, 0, 0]
 *     B = 0
 * Output 2:
 *     6
 */
public class SubArraySumEqualsToK {

	static int subArraySum(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, 1);
		int psum = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			psum += nums[i];
			if (hm.containsKey(psum - k)) {
				count += hm.get(psum - k);
			}
			hm.put(psum, hm.getOrDefault(psum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 4, 1, 5 };
		int k = 5;
		int ans = subArraySum(nums, k);
		System.out.println(ans);

	}

}
