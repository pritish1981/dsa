/**
 * 
 */
package binarysearch;

/**
 * @author Pritish
 *
 */
public class MedianSortedArray {
	//Time Complexity:O(min(log N, log M), Space Complexity: O(1)
	public static float findMedian(int[] ar1, int[] ar2) {
		if (ar2.length < ar1.length) {
			return findMedian(ar2, ar1);
		}
		int l = 0, h = ar1.length;
		while (l <= h) {
			int m1 = (l + h) / 2;
			int m2 = ((ar1.length + ar2.length + 1) / 2 - m1);

			int l1 = (m1 == 0) ? Integer.MIN_VALUE : ar1[m1 - 1];
			int r1 = (m1 == ar1.length) ? Integer.MAX_VALUE : ar1[m1];

			int l2 = (m2 == 0) ? Integer.MIN_VALUE : ar2[m2 - 1];
			int r2 = (m2 == ar1.length) ? Integer.MAX_VALUE : ar2[m2];

			if (l1 <= r2 && l2 <= r1) {
				if ((ar1.length + ar2.length) % 2 == 0) {
					return (float) (Integer.max(l1, l2) + Integer.min(r1, r2)) / 2;
				} else {
					return (float) Integer.max(l1, l2);
				}
			} else if (l2 > r1) {
				l = m1 + 1;
			} else {
				h = m1 - 1;
			}
		}
		return 0.0f;
	}

	public static void main(String[] args) {
		int[] ar1 = { 1, 3, 8, 17 };
		int[] ar2 = { 5, 6, 7, 19, 23, 25 };
		System.out.println("Median of the two sorted array is::" + findMedian(ar1, ar2));
	}

}
