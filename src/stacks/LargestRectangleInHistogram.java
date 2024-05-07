/**
 * 
 */
package stacks;

import java.util.Stack;

/**
 * Problem Description
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000

Input Format
The only argument given is the integer array A.

Output Format
Return the area of the largest rectangle in the histogram.

Example Input
Input 1:  A = [2, 1, 5, 6, 2, 3, 1]
Input 2:  A = [2]

Example Output
Output 1:  10
Output 2:  2

 *
 */
public class LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] heights) {
		int ans = 0;
		int nsl[] = nearestSmallerOnLeft(heights);
		int nsr[] = nearestSmallerOnRight(heights);
		for (int i = 0; i < heights.length; i++) {
			ans = Math.max(ans, (nsr[i] - nsl[i] - 1) * heights[i]);
		}
		return ans;
	}

	public static int[] nearestSmallerOnLeft(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			// pop all greater and equal elements
			while (!st.empty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				ans[i] = -1;
			else {
				ans[i] = st.peek();
			}
			// push current element
			st.push(i);
		}
		return ans;

	}

	public static int[] nearestSmallerOnRight(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			// pop all greater and equal elements
			while (!st.empty() && A[st.peek()] >= A[i]) {
				st.pop();
			}
			// update ans
			if (st.isEmpty())
				ans[i] = -1;
			else {
				ans[i] = st.peek();
			}
			// push current element
			st.push(i);
		}
		return ans;
	}
	
	//Approach 2: using single pass
	public static int largestRectangleArea1(int[] histo) {
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
		//Time Complexity: O(N), Space Complexity: O(N)
	}

	public static void main(String[] args) {
		int heights[] = { 2, 1, 5, 6, 2, 3, 1 };
		System.out.println("Maximum area of rectangle is " + largestRectangleArea(heights));
		System.out.println("Maximum area of rectangle using single pass is " + largestRectangleArea1(heights));

	}

}
