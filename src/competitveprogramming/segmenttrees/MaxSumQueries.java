package competitveprogramming.segmenttrees;

import java.util.ArrayList;

/*
Problem Description

You are given an array A of size N consisting of integers.

You have to process Q queries of two types on it:

i x, change the i-th element of A to x.
l r, find the maximum value of (A[i]+A[i+1]…A[j]) over all pairs (i,j) such that l <= i <= j <= r.


Problem Constraints

1 <= N,Q <= 105
-1000 <= A[i] <= 1000 (for all i in [1…N])
For query of the 1st type,

1 <= i <= N
-1000 <= x <= 1000
For query of the 2nd type,

1 <= l <= r <= N


Input Format

The first argument of the input is the array A.

The second argument of the input is a 2-D array B containing the description of the queries.



Output Format

You should return an array of answers to each query of the 2nd type, in the same order they were asked in the input.



Example Input

Input 1:

A: [3, -1, 2, -9, -15]

B: [
        [2,1,4],
        [1,3,7],
        [2,5,5],
        [2,1,3]
    ]
Input 2:

A: [6, -1, 9]

B:  [
        [2,1,3],
        [1,2,10],
        [2,1,3]
    ]


Example Output

Output 1:

[4, -15, 9]
Output 2:

[14, 25]


Example Explanation

Explanation 1:

For the 1st query, the required sum is A[1] + A[2] + A[3] = 4.
After the 2nd query, array becomes [3,-1,7,-9,-15].
For the 3rd query, there is only one answer possible, -15, which is thus the answer itself.
For the 4th query, the required sum is A[1] + A[2] + A[3] = 9.
Explanation 2:

For the 1st query, the required sum is A[1] + A[2] + A[3] = 14.
After the 2nd query, array becomes [6, 10, 9].
For the 3rd query, the required sum is A[1] + A[2] + A[3] = 14.
 */
class SegmentTreeNode{
    int start, end;
    int sum, prefixSum, suffixSum, maxSum;
    SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.prefixSum = 0;
        this.suffixSum = 0;
        this.maxSum = 0;
        this.left = null;
        this.right = null;
    }
}
public class MaxSumQueries {
    public SegmentTreeNode build(ArrayList<Integer> A, int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = A.get(start);
            node.prefixSum = A.get(start);
            node.suffixSum = A.get(start);
            node.maxSum = A.get(start);
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        node.prefixSum = Math.max(node.left.prefixSum, node.left.sum + node.right.prefixSum);
        node.suffixSum = Math.max(node.right.suffixSum, node.right.sum + node.left.suffixSum);
        node.maxSum = Math.max(Math.max(node.left.maxSum, node.right.maxSum), node.left.suffixSum + node.right.prefixSum);
        return node;
    }

    public void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
            root.prefixSum = val;
            root.suffixSum = val;
            root.maxSum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i <= mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
        root.prefixSum = Math.max(root.left.prefixSum, root.left.sum + root.right.prefixSum);
        root.suffixSum = Math.max(root.right.suffixSum, root.right.sum + root.left.suffixSum);
        root.maxSum = Math.max(Math.max(root.left.maxSum, root.right.maxSum), root.left.suffixSum + root.right.prefixSum);
    }

    public SegmentTreeNode query(SegmentTreeNode root, int l, int r) {
        if (root.start == l && root.end == r) {
            return root;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (r <= mid) {
            return query(root.left, l, r);
        } else if (l > mid) {
            return query(root.right, l, r);
        } else {
            SegmentTreeNode left = query(root.left, l, mid);
            SegmentTreeNode right = query(root.right, mid + 1, r);
            SegmentTreeNode result = new SegmentTreeNode(l, r);
            result.sum = left.sum + right.sum;
            result.prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);
            result.suffixSum = Math.max(right.suffixSum, right.sum + left.suffixSum);
            result.maxSum = Math.max(Math.max(left.maxSum, right.maxSum), left.suffixSum + right.prefixSum);
            return result;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        SegmentTreeNode root = build(A, 0, n - 1);
        ArrayList<Integer> ans = new ArrayList<>();

        for (ArrayList<Integer> b : B) {
            if (b.get(0) == 1) {
                update(root, b.get(1) - 1, b.get(2));
            } else {
                ans.add(query(root, b.get(1) - 1, b.get(2) - 1).maxSum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxSumQueries msq = new MaxSumQueries();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(-1);
        A.add(2);
        A.add(-9);
        A.add(-15);
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> b1 = new ArrayList<>();
        b1.add(2);
        b1.add(1);
        b1.add(4);
        B.add(b1);
        ArrayList<Integer> b2 = new ArrayList<>();
        b2.add(1);
        b2.add(3);
        b2.add(7);
        B.add(b2);
        ArrayList<Integer> b3 = new ArrayList<>();
        b3.add(2);
        b3.add(5);
        b3.add(5);
        B.add(b3);
        ArrayList<Integer> b4 = new ArrayList<>();
        b4.add(2);
        b4.add(1);
        b4.add(3);
        B.add(b4);
        System.out.println(msq.solve(A, B)); // [4, -15, 9]
    }
}
