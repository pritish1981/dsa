/**
 * 
 */
package binarysearch;

/**
 * Given an integer A representing the number of square blocks. The height of each square block is 1. 
 * The task is to create a staircase of max-height using these blocks.
   The first stair would require only one block, and the second stair would require two blocks, and so on.
   Find and return the maximum height of the staircase.
 *
 */
public class MaxHeightOfStairCase {

	static int solve(int blocks)
	{
	    int stairs = 0;
	    while (blocks != 0)
	    {
	        if (stairs + 1 <= blocks)
	        {
	            stairs++;
	            blocks = blocks - stairs;
	        }
	        else
	        {
	            break;
	        }
	         
	    }
	    return stairs;
	}
	
	public static void main(String[] args) {
		MaxHeightOfStairCase mh = new MaxHeightOfStairCase();
		//mh.solve(10);
		System.out.println(mh.solve(10));

	}

}
