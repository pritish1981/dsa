/**
 * 
 */
package dp.one;

/**
 * You are climbing a staircase and it takes A steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Return the number of distinct ways modulo 1000000007
 *
 */
public class ClimbingStairs {

	public static int mod = 1000000007;
    public static int climbStairs(int A) {
       int dp[] = new int[A+1];
       if(A == 1){
           return 1;
       }
       dp[1] = 1;
       dp[2] = 2;
       for(int i=3;i<=A;i++){
           dp[i] = (dp[i-1] + dp[i-2])% mod;
       }
       return dp[A];
    }
    

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Distinct ways to climb the stairs is :: " + climbStairs(n));

	}

}
