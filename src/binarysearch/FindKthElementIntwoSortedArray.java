/**
 * 
 */
package binarysearch;

/**
 * @author Pritish
 *
 */
public class FindKthElementIntwoSortedArray {
	
	/*static int count(int[] arr, int mid)
    {  // function to calculate number of elements less than equal to mid
        int cnt = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < mid)
                cnt++;
        return cnt;
    }*/
	
	static int count_of_smaller_elements(int[] arr, int k) {
		int n = arr.length;
		int low = 0, high = n - 1, ans = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] < k) {
				ans = mid + 1;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	static long kthElement(int[] A, int[] B, int k) {
		int n = A.length, m = B.length;
		int min = Math.min(A[0], B[0]);
		int max = Math.max(A[n - 1], B[m - 1]);
		int left = min, right = max, ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			//int x =count(A, mid);
			//x += count(B, mid);
			
			int x = count_of_smaller_elements(A, mid);
			x+= count_of_smaller_elements(B, mid );
			
			if (x <= k) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int A[] = { 3,8,9,11,24,40 };
	    int B[] = { 5,18,27,35};
	    int k = 4;
	    System.out.println("K'th element in two sorted array is:" + kthElement(A,B,k));

	}

}
