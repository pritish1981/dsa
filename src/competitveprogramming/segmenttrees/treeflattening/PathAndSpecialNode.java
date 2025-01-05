package competitveprogramming.segmenttrees.treeflattening;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description:
Given a Tree with N nodes numbered 1 to N. Also, given a special node denoted by integer A.
2D array B of size (N-1) x 2 denotes the edges between the nodes of Tree.
You are asked to answer Q queries of the following type:
For each query, given two integers X and V, Output 1 if X exists in the path of (A, V). Else output 0.

Problem Constraints:
1 <= N, Q <= 10^5
1 <= A, B[i][0], B[i][1], X, V <= N
Input Format:
First argument is an integer A denoting the special Node.
Second argument is a 2D array B of size N-1 x 2, where ith edge if between B[i][0] and B[i][1] node.
Third argument is a 2D array C of size Q x 2. For ith Query, X = C[i][0] and V = C[i][1].

Output Format:
Return an integer array of size Q denoting the output of every query.
Example Input:

Input 1:

 A = 1
 B = [
       [1, 2]
       [1, 3]
       [1, 4]
       [3, 5]
       [3, 6]
     ]
 C = [
       [5, 6]
       [3, 5]
       [4, 2]
     ]

Input 2:

 A = 3
 B = [
       [1, 2]
       [1, 3]
       [1, 4]
       [3, 5]
       [3, 6]
       [2, 8]
       [4, 7]
     ]
 C = [
       [1, 7]
       [5, 8]
       [5, 5]
     ]

     Example Output:

   Output 1: [0, 1, 0]
   Output 2: [1, 0, 1]

   Explanation 1:

 Tree:         1
             / | \
            2  3  4
              / \
             5   6
 Special Node: 1
 First Query : X = 5, V = 6. Path (1, 6) = 1 -> 3 -> 6, there is no node 5 in the path. So output 0.
 Second Query: X = 3, V = 5. Path (1, 5) = 1 -> 3 -> 5, there is node 3 in the path. So output 1.
 Third Query : X = 4, V = 2. Path (1, 2) = 1 -> 2, there is no node 4 in the path. So output 0.

 */
public class PathAndSpecialNode {
    final int maxN = 100005;
    ArrayList<ArrayList<Integer>> adj;
    int[] in = new int[maxN];
    int[] out = new int[maxN];
    int timer;

    void init() {
        adj = new ArrayList<ArrayList<Integer>>(maxN);
        for (int i = 0; i < maxN; i++) {
            adj.add(new ArrayList<>());
        }
        Arrays.fill(in, 0);
        Arrays.fill(out, 0);
        timer = 0;
    }

    void dfs(int node, int parent) {
        in[node] = timer++;
        for (int child : adj.get(node)) {
            if (child != parent) {
                dfs(child, node);
            }
        }
        out[node] = timer++;
    }

    public int[] solve(int A, int[][] B, int[][] C) {
        init();
        int n = B.length;
        for (int i = 0; i < n; i++) {
            adj.get(B[i][0]).add(B[i][1]);
            adj.get(B[i][1]).add(B[i][0]);
        }
        dfs(A, -1);
        int[] res = new int[C.length];
        for (int i = 0; i < C.length; i++) {
            int x = C[i][0];
            int v = C[i][1];
            if (in[v] >= in[x] && out[v] <= out[x]) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PathAndSpecialNode psn = new PathAndSpecialNode();
        int A = 1;
        int[][] B = {
                {1, 2},
                {1, 3},
                {1, 4},
                {3, 5},
                {3, 6}
        };
        int[][] C = {
                {5, 6},
                {3, 5},
                {4, 2}
        };
        int[] res = psn.solve(A, B, C);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
