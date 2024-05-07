/**
 * 
 */
package binarysearch;

/**
 * @author Pritish
 *
 */
public class FloorSquareRoot {

	static int floorSqrt(int A) {
		int left = 1, right = A, ans = 0;
		// Base Cases
        if (A == 0 || A == 1)
            return A;
		while(left <= right) {
			int mid = (left + right)/2;
			if(mid * mid == A) {
				ans = mid;
				break;
			}else if(mid * mid < A) {
				ans = mid;
				left = mid + 1;
			}else {
				right = mid -1;
			}
		}
		return ans;
	}
	
	static int floorSqureRoot(int A) {
		// Base Cases
				if (A == 0 || A == 1)
					return A;

				// Do Binary Search for floor(sqrt(x))
				long start = 1, end = A / 2, ans = 0;
				while (start <= end) {
					long mid = (start + end) / 2;

					// If x is a perfect square
					if (mid * mid == A)
						return (int)mid;

					// Since we need floor, we update answer when
					// mid*mid is smaller than x, and move closer to
					// sqrt(x)
					if (mid * mid < A) {
						start = mid + 1;
						ans = mid;
					}
					else // If mid*mid is greater than x
						end = mid - 1;
				}
				return (int)ans;
	}
	public static void main(String[] args) {
		int x = 11;
        System.out.println(floorSqrt(x));

	}

}
