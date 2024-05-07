/**
 * 
 */
package heap2;

import java.util.PriorityQueue;

/**
 * Given a sorted matrix of integers A of size N x M and an integer B.
Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
 *
 */
public class KthSmallestElementInASortedMatrix {

	public static int solve(int[][] matrix, int k) {
		//build a max heap where root node has max value
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				//store in maxHeap
				maxHeap.offer(matrix[i][j]);
				//remove the largest element if size is > k
				if(maxHeap.size() > k)
					maxHeap.poll();
			}
		}
		return maxHeap.peek();
    }

	public static void main(String[] args) {
		int[][] A = { { 9, 11, 15 },
				      { 10, 15, 17 } };
		int B = 6;
		System.out.println(solve(A,B));

	}

}
