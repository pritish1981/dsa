/**
 * 
 */
package tct2;

/**
 * @author User
 *
 */
public class test3 {
	public static int solve(int[] A, int B) {
		if(subSetSumToK(A,B) == true) {
			return 1;
		}else {
			return 0;
		}
	}

	public static boolean subSetSumToK(int[] A, int B) {
		int n = A.length;
		// create an array to store prev value of dp table
		boolean prev[] = new boolean[B + 1];
		// initialize 1st row of dp table
		prev[0] = true;
		// initialize 1st column of dp table
		if (A[0] <= B) {
			prev[A[0]] = true;
		}
		// fill up dp table in bottom-up approach
		for (int i = 1; i < n; i++) {
			// create an array to store the current row of dp table
			boolean cur[] = new boolean[B + 1];
			// initialize the 1st column of the current row
			cur[0] = true;

			for (int j = 1; j <= B; j++) {
				// calculate if the current target can be achived without taking the current
				// element
				boolean notTaken = prev[j];
				// calculate if the current target can be achived by taking the current element
				boolean taken = false;
				if (A[i] <= j) {
					taken = prev[j - A[i]];
				}
				// store the result in the curreent row of dp table
				cur[j] = notTaken || taken;
			}
			// update prev row with current row
			prev = cur;
		}
		// the final result is stored in the last cell of the previous row
		return prev[B];
	}
	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4 };
        int B = 4;
       // int n = A.length;
        if (subSetSumToK(A,B))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
        System.out.println("subset with given sum "+solve(A,B));
	}

}
