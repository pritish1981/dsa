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
Solution Approach:

1.Finding Nearest Smaller and Larger Elements:
We use stacks to efficiently find the nearest smaller and larger elements to the left and right of each element in the array.
This preprocessing step allows us to quickly determine the range of sub-arrays where each element is the minimum or maximum.

2.Calculating Contributions:
For each element, calculate the number of sub-arrays where it is the minimum and the number where it is the maximum.
The product of the distances to the nearest smaller and larger elements gives us the number of sub-arrays where the current element is either the minimum or the maximum.

3.Summing the Results:
The total number of sub-arrays is 𝑁 × (𝑁+1)/2

By subtracting the number of sub-arrays where the current element is the minimum or maximum from the total, we get the number of sub-arrays where it is neither.

 */
public class SubArrayHeight {
    public long solve(int[] A) {
        int n = A.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Compute leftMin
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Compute rightMin
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Compute leftMax
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            leftMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Compute rightMax
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            rightMax[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate total number of subarrays
        long totalSubarrays = (long) n * (n + 1) / 2;
        long sumOfExcluded = 0;

        // Calculate sum of excluded subarrays where each element is min or max
        for (int i = 0; i < n; i++) {
            long minCount = (long) (i - leftMin[i]) * (rightMin[i] - i);
            long maxCount = (long) (i - leftMax[i]) * (rightMax[i] - i);
            sumOfExcluded += minCount + maxCount;
        }

        // Subtract the number of subarrays where the element is both min and max twice
        return totalSubarrays - sumOfExcluded / 2;
    }

    public static void main(String[] args) {
        SubArrayHeight sol = new SubArrayHeight();
        int[] A = {11, 20, 17};
        long result = sol.solve(A);
        System.out.println("Sum of middle elements in all subarrays: " + result);
    }
}
