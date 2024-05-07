
package matrix;

/**
 * Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, 
 * such that the sum of all the elements in the submatrix is maximum.
 *
 */
public class MaximumSumSqaureSubMatrix {

	public static int solve(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[][] dp = new int[row+1][col+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //sum total
            dp[i][j] = A[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int sum = Integer.MIN_VALUE;
                if(i-B >= 0 && j-B >= 0){
                    sum = dp[i][j] - dp[i-B][j] - dp[i][j-B] + dp[i-B][j-B];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
	public static void main(String[] args) {
		int[][] A = { { 1, 1, 1, 1, 1 },
                { 2, 2, 2, 2, 2 },
                { 3, 8, 6, 7, 3 },
                { 4, 4, 4, 4, 4 },
                { 5, 5, 5, 5, 5 } };
        int B = 3;
        System.out.println("Maximum sum 3 x 3 matrix is");
        int ans = solve(A, B);
        System.out.println(ans);
        

	}

}
