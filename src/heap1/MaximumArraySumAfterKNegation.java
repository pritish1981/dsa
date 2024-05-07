/**
 * 
 */
package heap1;

import java.util.Arrays;

/**
 * Given an array of integers A and an integer B. You must modify the array exactly B number of times.
 * In a single modification, we can replace any one array element A[i] by -A[i].
   You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
 *
 */
public class MaximumArraySumAfterKNegation {

	// Function to calculate sum of the array
    static int sumArray(int[] arr, int n)
    {
        int sum = 0;
        // Iterate from 0 to n - 1
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum;
    }
  
    // Function to maximize sum
    static int maximizeSum(int A[],int B)
    {
    	int n = A.length;
        Arrays.sort(A);
        int i = 0;
  
        // Iterate from 0 to n - 1
        for (i = 0; i < n; i++) {
            if (B != 0 && A[i] < 0) {
                A[i] *= -1;
                B--;
                continue;
            }
            break;
        }
        if (i == n)
            i--;
  
        if (B == 0 || B % 2 == 0)
            return sumArray(A, n);
  
        if (i != 0 && Math.abs(A[i]) >= Math.abs(A[i - 1]))
            i--;
  
        A[i] *= -1;
        return sumArray(A, n);
    }
	
	public static void main(String[] args) {
		int n = 5;
        int arr[] = { -2, 0, 5, -1, 2 };
        int k = 4;
        // Function Call
        System.out.print(maximizeSum(arr, k));

	}

}
