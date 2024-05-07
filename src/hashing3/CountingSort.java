/**
 * 
 */
package hashing3;

import java.util.Arrays;

/**
 * @author Pritish
 *
 */
public class CountingSort {

	static int getMax(int[] A) {  
		  int n = A.length;
		  int max = A[0];  
		  for(int i = 1; i<n; i++) {  
		      if(A[i] > max)  
		         max = A[i];  
		  }  
		  return max; //maximum element from the array  
		}  

		public static int[] countSort(int[] A) {
			int n = A.length;
			int[] output = new int[n + 1];
			int max = getMax(A);
			int[] count = new int[max + 1]; // create count array with size [max+1]
			for (int i = 0; i <= max; ++i) {
				count[i] = 0; // Initialize count array with all zeros
			}

			for (int i = 0; i < n; i++) // Store the count of each element
			{
				count[A[i]]++;
			}
			for (int i = 1; i <= max; i++)
				count[i] += count[i - 1]; // find cumulative sum

			/*
			 * This loop will find the index of each element of the original array in count
			 * array, and place the elements in output array
			 */
			for (int i = n - 1; i >= 0; i--) {
				output[count[A[i]] - 1] = A[i];
				count[A[i]]--; // decrease count for same numbers
			}
			for (int i = 0; i < n; i++) {
				A[i] = output[i]; // store the sorted elements into main array
			}
          return A;
		}
	public static void main(String[] args) {
		 int A[] = { 4,2,1,3 };  
		 //int n = A.length; 
		 int[] ans = countSort(A);
		 System.out.println(Arrays.toString(A));

	}

}
