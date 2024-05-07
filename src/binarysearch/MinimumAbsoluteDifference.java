/**
 * 
 */
package binarysearch;

import java.util.Arrays;

/**
 * @author Pritish
 *
 */
public class MinimumAbsoluteDifference {

	// Return smallest element greater than or equal to the current element.
	static int bsearch(int low, int high, int n, int arr[])
	{
	    int mid = (low + high)/2;
	 
	    if(low <= high)
	    {
	        if(arr[mid] < n)
	            return bsearch(mid +1, high, n, arr);
	        return bsearch(low, mid - 1, n, arr);
	    }
	 
	    return low;
	}
	
	// Return the minimum absolute difference adjacent
	// elements of array
	static int mindiff(int C[][], int A, int B)
	{
	    // Sort each row of the matrix.
	    for (int i = 0; i < A; i++)
	    	Arrays.sort(C[i]);
	        
	 
	    int ans = +2147483647;
	 
	    // For each matrix element
	    for (int i = 0; i < A - 1; i++)
	    {
	        for (int j = 0; j < B; j++)
	        {
	 
	        // Search smallest element in the
	        // next row which is greater than
	        // or equal to the current element
	        int p = bsearch(0, B-1, C[i][j], C[i + 1]);
	        ans = Math.min(ans, Math.abs(C[i + 1][p] - C[i][j]));
	 
	        // largest element which is smaller than the current
	        // element in the next row must be just before
	        // smallest element which is greater than or equal
	        // to the current element because rows are sorted.
	        if (p-1 >= 0)
	            ans = Math.min(ans,
	                        Math.abs(C[i + 1][p - 1] - C[i][j]));
	        }
	    }
	    return ans;
	}
	public static void main(String[] args) {
		int [][] C ={{8, 5},
                {6, 8}};
        int A=2,B=2;
        System.out.println(mindiff(C, A, B));

	}

}
