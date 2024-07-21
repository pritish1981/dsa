package competitveprogramming.segmenttrees;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

Given an integer array A of size N.

You have to perform two types of query, in each query you are given three integers x,y,z.

If x = 0, then update A[y] = z.
If x = 1, then output the minimum element in the array A between index y and z inclusive.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.



Problem Constraints

1 <= N, M <= 105

1 <= A[i] <= 109

If x = 0, 1<= y <= N and 1 <= z <= 109

If x = 1, 1<= y <= z <= N



Input Format

First argument is an integer array A of size N.

Second argument is a 2-D array B of size M x 3 denoting queries.



Output Format

Return an integer array denoting the output of each query where value of x is 1.



Example Input

Input 1:

 A = [1, 4, 1]
 B = [
        [1, 1, 3]
        [0, 1, 5]
        [1, 1, 2]
     ]
Input 2:

 A = [5, 4, 5, 7]
 B = [
        [1, 2, 4]
        [0, 1, 2]
        [1, 1, 4]
     ]


Example Output

Output 1:

 [1, 4]
Output 2:

 [4, 2]

 */
public class RangeMinimumQuery {
    static int maxn = 400009;
    static int[] seg = new int[maxn];
    public int[] solve(int[] A, int[][] B) {
        Arrays.fill(seg, 0);
        int n = A.length;
        int m = B.length;
        build(1, 0, n - 1, A);
        ArrayList < Integer > ans = new ArrayList < > ();
        for (int i = 0; i < m; i++) {
            int x = B[i][0];
            int y = B[i][1];
            int z = B[i][2];
            if (x == 1)
                ans.add(query(1, 0, A.length - 1, y - 1, z - 1));
            else
                update(1, 0, A.length - 1, y - 1, z);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
    public static void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            seg[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        seg[node] = Math.min(seg[2 * node], seg[2 * node + 1]);
    }
    public static void build(int node, int start, int end, int[] A) {
        if (start == end) {
            seg[node] = A[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, A);
        build(2 * node + 1, mid + 1, end, A);
        seg[node] = Math.min(seg[2 * node], seg[2 * node + 1]);
    }
    public static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return Integer.MAX_VALUE;
        }
        if (l <= start && end <= r) {
            return seg[node];
        }
        int mid = (start + end) / 2;
        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);
        return Math.min(left, right);
    }
    public static void main(String[] args) {
        RangeMinimumQuery rmq = new RangeMinimumQuery();
        int[] A = {1, 4, 1};
        int[][] B = {
                {1, 1, 3},
                {0, 1, 5},
                {1, 1, 2}
        };
        int[] ans = rmq.solve(A, B);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
