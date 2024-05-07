/**
 * 
 */
package stacks;

import java.util.Stack;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Input Format :

The only argument given is the integer matrix A.
Output Format :

Return the area of the largest rectangle containing only 1's.
Constraints :
1 <= N, M <= 1000
0 <= A[i] <= 1

For Example :

Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:    4

Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:   1
 *
 */
public class MaximalRectangle {
	
	/*
	 * Intuition :
1) Pick one row
2) Do summation of each index till that row
		i) if any index value is 0 then put 0 else previous summation + 1 
3) Pass this array to get max area (84. Largest Rectangle in Historgram)
4) Update max area
	 * 
	 */

	public static int maximalRectangle(int[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int r = matrix.length;
		int c = matrix[0].length;
		int maxArea = 0;
		int[] height = new int[c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 1)
					height[j]++;
				else
					height[j] = 0;
			}
			maxArea = Math.max(maxArea, largestRectangleArea(height));
		}
		return maxArea;
	}
	
	//Approach 2: using single pass
	public static int largestRectangleArea(int[] histo) {
		Stack<Integer> st = new Stack<Integer>();
		int maxA = 0;
		int n = histo.length;
		for (int i = 0; i <= n; i++) {
			while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
				int height = histo[st.peek()];
				st.pop();
				int width;
				if (st.empty())
					width = i;
				else {
					width = i - st.peek() - 1;
				}
				maxA = Math.max(maxA, height * width);
			}
			st.push(i);
		}
		return maxA;
		// Time Complexity: O(N), Space Complexity: O(N)
	}

	
	public static void main(String[] args) {
		int[][] A = { { 0, 0, 1 },
				      { 0, 1, 1 },
				      { 1, 1, 1 } };

		System.out.println(maximalRectangle(A));
	}
	// Time: O(N*M) & Space: O(M)
}
