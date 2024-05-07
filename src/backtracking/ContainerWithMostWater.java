/**
 * 
 */
package backtracking;

/**
 * Given N array elements, where each arr[i] represents height of the each wall, Pick any 2 walls such that 
 * maximum water is accumulated between them.
 *
 */
public class ContainerWithMostWater {

	public static int maxWater(int[] arr) {
		int n = arr.length;
		int i = 0, j = n - 1, ans = 0;
		while (i < j) {
			int water_accumlated = (j - i) * Math.min(arr[i], arr[j]);
			ans = Math.max(ans, water_accumlated);
			if (arr[i] < arr[j]) {
				i++;
			} else {
				j--;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1,5,4,3};
        System.out.println(maxWater(arr));
	}

}
