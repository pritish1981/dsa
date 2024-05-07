/**
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all 
 * the numbers less than or equal to B together.Note: It is possible to swap any two elements, not necessarily consecutive.
 */
package matrix;

public class MinimumSwap {

	public static int minSwap(int[] A, int B) {
        int n = A.length;
        int snowBallSize = 0;
        for(int i=0;i<n;i++){
            //calculating the size of the window required
            if(A[i] <= B){
                snowBallSize++;
            }
        }
        int swap = 0, ans_swap = Integer.MAX_VALUE;
        for(int i=0;i < snowBallSize; i++){
            if(A[i] > B){
                swap++;
            }
        }
        ans_swap = Math.min(ans_swap, swap);
        for( int i=snowBallSize; i<n;i++){
            //checking in every window no.of swaps required & storing it's minimum
            if(A[i-snowBallSize] <= B && A[i] > B)
             swap++;
            else if(A[i-snowBallSize] > B && A[i] <= B)
             swap--;
             ans_swap = Math.min(ans_swap, swap);
        }
        return ans_swap;
    }
	public static void main(String[] args) {
		int A[] = { 2, 7, 9, 5, 8, 7, 4 };
		int B =5;
		System.out.println(minSwap(A,B));

	}

}
