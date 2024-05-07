/**
 * 
 */
package arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

 
 *
 */
public class MoveZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		
	}
	
	public static void moveZeros(int[] nums) {
		int i = 0;
		for(final int num : nums) {
			if(num != 0)
				nums[i++] = num;
		}
		while(i < nums.length) {
			nums[i++] = 0;
		}
	}

}
