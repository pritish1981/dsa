/**
 * 
 */
package math.bitmaniulation;

/**
 * @author Pritish
 *
 */
public class RearrangeArray {

	void arrange(int[] A) {
		int n = A.length;
		// First step: Increase all values by (arr[arr[i]]%n)*n
		for (int i = 0; i < n; i++)
			A[i] += (A[A[i]] % n) * n;
		// Second Step: Divide all values by n
		for (int i = 0; i < n; i++)
			A[i] /= n;

	}

	void printArr(int[] A, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {

		int A[] = { 3, 2, 0, 1 };
		int n = A.length;
		RearrangeArray ra = new RearrangeArray();
		System.out.println("Given Array is :");
		ra.printArr(A, n);
		ra.arrange(A);

		System.out.println("Modified Array is :");
		ra.printArr(A, n);

	}

}
