package tct2;

import java.util.Stack;

/*
Average People:
Given an array A representing heights of N students. For every subarray find the number of people say x, who are
neither the shortest nor the tallest in the subarray. Find and return sum of the values x for all sub arrays
of the array.

Problem Constraints:
1<=N<=10^5
1<=A[i]<=10^9

Input Format: The first input is an integer array A
Output Format: Return the sum of the values x for all sub-arrays of the array.

Example Input:
Input 1: A = [11,20,17],  Output: 1
Input 2: A = [30,47,19,23], Output: 4

 */
/*
Optimized Approach:
Precompute Necessary Information: Precompute the left and right limits where the current element is the minimum or maximum.
Calculate Contribution Efficiently: Use the precomputed information to calculate the contribution of each element to the final answer without iterating
over all sub-arrays explicitly.

Explanation:
We will use arrays to store the nearest left and right positions where the current element is smaller (or larger) than any other element.
Using these arrays, we can determine the number of sub-arrays in which each element is the minimum or maximum.
Then, the total number of sub-arrays that include each element can be computed and the elements that are neither minimum nor maximum can be derived from this information.
 */
public class SubArrayHeight {
    public static long sumOfMiddleElements(int[] heights) {
        int n = heights.length;

        // Arrays to store the indices of the nearest smaller elements on the left and right
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        // Arrays to store the indices of the nearest larger elements on the left and right
        int[] leftLarger = new int[n];
        int[] rightLarger = new int[n];

        // Initialize stacks to find nearest smaller and larger elements
        Stack<Integer> stack = new Stack<>();

        // Find nearest smaller elements to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find nearest smaller elements to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find nearest larger elements to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            leftLarger[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find nearest larger elements to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            rightLarger[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long totalSubarrays = (long) n * (n + 1) / 2;
        long totalExcluded = 0;

        // Calculate total excluded subarrays where the element is the minimum or maximum
        for (int i = 0; i < n; i++) {
            long minSubarrays = (long) (i - leftSmaller[i]) * (rightSmaller[i] - i);
            long maxSubarrays = (long) (i - leftLarger[i]) * (rightLarger[i] - i);
            totalExcluded += minSubarrays + maxSubarrays;
        }

        // The number of subarrays where each element is neither the minimum nor the maximum
        return totalSubarrays - totalExcluded;
    }

    public static void main(String[] args) {
        int[] heights = {11, 20, 17};
        long result = sumOfMiddleElements(heights);
        System.out.println("Sum of middle elements in all subarrays: " + result);
    }

}
