/**
 * 
 */
package arrays;

/**
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
 *
 */
public class FirstMissingPositiveNumber {
	
	//Step 1. This means that all numbers less than 1 and greater than N are useless, and we can replace them with N+1. All numbers in the array are now positive, and in the range [1..N+1].
	//Step 2. We can mark each cell that appears in the array by converting the index for that number to negative
	//Step 3. Find the first index which is positive that is our answer.

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		int fakeNumber = n + 1;
      //step1:
		for (int i = 0; i < n; i++) {
			if (nums[i] < 1 || nums[i] > n) {
				nums[i] = fakeNumber;
			}
		}
       //step2:
		for (int i = 0; i < n; i++) {
			int num = Math.abs(nums[i]);
			if (num == fakeNumber) {
				continue;
			}
			num--;
			if (nums[num] > 0) {
				nums[num] *= -1;
			}
		}
        //step3:
		for (int i = 0; i < n; i++) {
			if (nums[i] >= 0) {
				return i + 1;
			}
		}
		return n + 1;

	}
	
	//Time complexity: O(n)
	//Space complexity: O(1)
	
	public static int solve(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return n + 1;
	}

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,0};
		System.out.println("First missing positive number in a array1 is::"+firstMissingPositive(nums));
		
		int[] nums1 = {3,4,-1,1};
		System.out.println("First missing positive number in a array2 is::"+firstMissingPositive(nums1));
		
		
		int[] nums3 = {3,4,-1,1};
		System.out.println("First missing positive number in a array3 is::"+solve(nums3));

	}

}
