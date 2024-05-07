/**
 * 
 */
package binarysearch;

/**
 * Every elements repeats twice except one, find the unique element.
 *
 */
public class FindUniqueElement {

	static int uniqueElement(int[] A) {
		int n = A.length;
		int left = 1, right = n-2;
		if(n == 1) return A[0];
		if(A[0] != A[1]) return A[0];
		if(A[n-1] != A[n-2]) return A[n-1];
		while(left <= right) {
			int mid = (left+right)/2;
			if(A[mid] != A[mid-1] && A[mid] != A[mid+1]) {
				return A[mid];
			}
			//Find 1st occurrence of duplicate pair
			int fo = mid;
			if(A[mid] == A[mid-1]) {
				fo = mid -1;
			}else {
				fo = mid;
			}
			if(fo % 2 == 0) {
				left = fo + 2;
			}else {
				right = fo - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {3,3,1,1,8,8,9,2,2,4,4};
        System.out.println(uniqueElement(A));
	}

}
