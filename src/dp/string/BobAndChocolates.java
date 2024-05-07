/**
 * 
 */
package dp.string;

/**
 * You are in a chocolate shop that sell N number of different chocolates. You are given that the price of each chocolate  is B[i]
 * and the sweetness of each chocolate is C[i]. Total price of the purchase will be atmost A , you can buy each chocolate
 * at most once. What is the maximum sweetness we can get using at-most A rupees.
 * 
 * Constraints:
 * 1<=N<=10^3
 * 1<=A<=10^5
 * 1<=B[i]<=10^3
 * 1<=C[i]<=10^3
 *
 */
public class BobAndChocolates {

	/**
	 * 0/1 - kanpsack
	 */
	public static void main(String[] args) {
		int A = 10; // budget
		int B[] = {4,8,5,3}; // price
        int C[] = {5,12,8,1}; // sweetness
        System.out.println("Maximum sweetness we can get with at-most A rupees is::" +  solve(A,B,C));
	}
	
	public static int solve(int budget, int[] price, int[] sweetness) {
		int dp1[] = new int[budget + 1];
		int dp2[] = new int[budget + 1];
		for (int i = 1; i <= price.length; i++) {
			for (int j = 1; j <= budget; j++) {
				// if you don't buy chocolate
				dp2[j] = dp1[j];
				// if you buy the chocolate
				if (j - price[i - 1] >= 0) {
					dp2[j] = Math.max(dp1[j], sweetness[i - 1] + dp1[j - price[i - 1]]);
				}
			}
			dp1 = dp2;
			dp2 = new int[budget + 1];
		}
		return dp1[budget];
	}

}
