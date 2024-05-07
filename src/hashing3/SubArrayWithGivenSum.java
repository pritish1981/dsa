/**
 * 
 */
package hashing3;

import java.util.Arrays;

/**
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
   If the answer does not exist return an array with a single element "-1".
 *
 */
public class SubArrayWithGivenSum {
   //return sub array start & end index
	public static int[] subArray(int[] A, int B) {
		int len = A.length;
		int start = 0, end =1, sum = A[0];
		while(end <= len) {
			while (sum > B && start < end -1) {
				sum = sum - A[start];
				start++;
			}
			if(sum == B) 
				return new int[] { start, end -1};
			
			if(end < len) 
				sum = sum + A[end];
			end++;
		}
		return new int[] {-1};
	}
	//return sub array
	public static int[] solve(int[] A, int B) {
        long n = A.length;
        int left = 0, right = 0;
        long sum = A[left];
        while (right < n) {
            if (sum == B) {
                // current window sum = B
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; i++)
                	ans[i - left] = A[i];
                    return ans;
            } else if (sum < B) {
                // current window sum < B
                right++;
                if (right < n) sum += A[right];
            } else {
                // current window sum > B
                sum -= A[left];
                left++;
                if (left > right && left < n - 1) {
                    right++;
                    sum += A[right];
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
    };
		
		
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int B = 5;
		int[] ans = solve(A,B);
		System.out.println(Arrays.toString(ans));

	}

}
