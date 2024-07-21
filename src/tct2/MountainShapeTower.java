package tct2;
/*
you are given an array A of N integers representing the number of bricks in n consecutive towers.
Your task is to remove some bricks to form a mountain-shaped tower arrangement. In this arrangement the tower
 heights are non-decreasing , reaching a maximum peak value with one or multiple consecutive towers and then
 non-increasing. Return the maximum possible sum of heights of a mountain-shaped tower arrangement.
 sample input: A : [5,3,4,1,1]

Problem Constraint:
1<=A.size()<= 10^3
1<=A[i]<=10^9

 */
public class MountainShapeTower {
    public static int maxMountainSum(int[] A) {
        int n = A.length;
        if (n < 3) return 0;  // A mountain requires at least 3 towers

        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize the left and right arrays with the values of A

        left[0] = A[0];
        right[n - 1] = A[n - 1];
       // System.arraycopy(A, 0, left, 0, n);
       // System.arraycopy(A, 0, right, 0, n);

        // Fill the left array with max sum for non-decreasing subsequences
        for (int i = 1; i < n; i++) {
            if (A[i] >= A[i - 1]) {
                left[i] = left[i - 1] + A[i];
            } else {
                left[i] = A[i];
            }
        }

        // Fill the right array with max sum for non-increasing subsequences
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] >= A[i + 1]) {
                right[i] = right[i + 1] + A[i];
            } else {
                right[i] = A[i];
            }
        }

        // Find the maximum sum of the mountain-shaped arrangement
        int maxSum = 0;
        for (int i = 1; i < n - 1; i++) {
            if (A[i] >= A[i - 1] && A[i] >= A[i + 1]) { // Peak condition
                maxSum = Math.max(maxSum, left[i] + right[i] - A[i]);
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] A = {5, 3, 4, 1, 1};
        int[] B = {6, 5, 3, 9, 2,7};
        System.out.println("Maximum Mountain Sum: " + maxMountainSum(A)); // Output: 12
    }
}
