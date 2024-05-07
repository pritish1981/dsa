/**
 * 
 */
package binarysearch;

/**
 * @author Pritish
 *
 */
public class FindLocalMinima {

	static int localMinima(int[] A) {
		int n = A.length;
		int left = 0, right = n-1;
		int mid = (left+right)/2;
		if(n == 1) return A[0];
		if(A[0] < A[1]) return A[0];
		if(A[n-1] < A[n-2]) return A[n-1];
		while(left <= right) {
			if(A[mid] < A[mid-1] && A[mid] < A[mid+1]) {
				return A[mid];
			}else if(A[mid] > A[mid -1]) {
				right = mid-1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int[] A = {9,8,7,3,6,4,1,5};
        System.out.println(localMinima(A));
	}

}
