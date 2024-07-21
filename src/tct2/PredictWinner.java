package tct2;
/*
Predict the winner:
You are given an integer array A. Two players are playing the game with this array: player 1 and player 2
Player 1 and Player 2 take turns, with player 1 starting first. Both players start the game with score 0.
At each turn , the player takes one of the numbers from either end of the array (i.e : A[0] or A[A.length-1],
which reduces the size of the array by 1.The player adds the chosen number to their score.The game ends when
there are no more elements in the array.

return 1 if player 1 wins the game. If the score of both players are equal, then player 1 is still the winner
and you should also return 1. If player 2 wins the game  return 0.
You may assume that both players are playing optimally.

Problem Constraint:
1<A.length<=20
1<=A[i]<=10^7
 */
public class PredictWinner {
    public static int predictWinner(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        // Initialize the dp array where dp[i][i] is the value of the single element A[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = A[i];
        }

        // Fill the dp array for all subarrays of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(A[i] - dp[i + 1][j], A[j] - dp[i][j - 1]);
            }
        }

        // If the value at dp[0][n-1] is >= 0, player 1 can win or tie the game
        return dp[0][n - 1] >= 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 2};
        System.out.println(predictWinner(A)); // Output: 0

        int[] B = {1, 5, 233, 7};
        System.out.println(predictWinner(B)); // Output: 1
    }
}
