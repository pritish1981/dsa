package competitveprogramming.segmenttrees.treeflattening;

import java.util.ArrayList;

/*
Problem Description

Given a tree of A nodes numbered 1 to A rooted at node 1. Each node can have 0 or 1 value. Initially all nodes have value 1.

You have to perform Q queries of 3 types:

1 X: All nodes in the subtree of node X(excluding X) will become 1.
2 X: All nodes in the subtree of node X(excluding X) will become 0.
3 X: Count the nodes which have value 1 in the subtree of node X(excluding X).


Problem Constraints

1 <= A, Q <= 10^5

1 <= X <= A

1 <= C[i][0] <= 3



Input Format

First argument is an integer A denoting number of nodes.
Second argument is a 2D array B of size (A - 1) x 2 denoting the edges between B[i][0] and B[i][1] nodes.
Third argument is a 2D array C of size Q x 2 denoting queries. C[i][0] denotes the type and C[i][1] denotes X.

Output Format

Return an integer array denoting the output of queries of type 3.

Example Input

Input 1:

 A = 7
 B = [
       [1, 2]
       [1, 3]
       [2 ,4]
       [3, 5]
       [3, 6]
       [3, 7]
     ]
 C = [
       [1, 1]
       [2, 3]
       [3, 3]
       [3, 1]
     ]
Input 2:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
 C = [
       [1, 1]
       [2, 3]
       [3, 3]
       [3, 1]
     ]


Example Output

Output 1:

 [0, 3]
Output 2:

 [0, 2]


Example Explanation

Explanation 1:

        1
       / \
      2   3
     /   /|\
    4   5 6 7
 Initially all nodes have value 1.
 First Query: Make all nodes with value 1 in the subtree of node 1 (excluding node 1).
 Second Query: Make all nodes with value 0 in the subtree of node 3 (excluding node 3). So node {5, 6, 7} have value 0.
 Third Query: Nodes with value 1 in the subtree of node 3(excluding) i.e 0.
 Fourth Query: Nodes with value 1 in the subtree of node 1(excluding). Nodes are {2, 3, 4}, total 3.
Explanation 2:

        1
       / \
      2   3
 First Query: Make all nodes with value 1 in the subtree of node 1 (excluding node 1).
 Second Query: Make all nodes with value 0 in the subtree of node 3 (excluding node 3). No node in subtree.
 Third Query: Nodes with value 1 in the subtree of node 3(excluding) i.e 0 (no node).
 Fourth Query: Nodes with value 1 in the subtree of node 1(excluding). Nodes are {2, 3}, total 2.
 */
public class ZeroOneNode {
    ArrayList<ArrayList<Integer>> adj;
    int[] values;

    private void dfs_update(int node, int parent, int val) {
        for(int child : adj.get(node)) {
            if(child != parent) {
                values[child] = val;
                dfs_update(child, node, val);
            }
        }
    }

    private int dfs_count(int node, int parent) {
        int count = 0;
        for(int child : adj.get(node)) {
            if(child != parent) {
                count += values[child];
                count += dfs_count(child, node);
            }
        }
        return count;
    }
    public int[] solve(int A, int[][] B, int[][] C) {
        //Initialising the adjacency list
        adj = new ArrayList<>();
        for(int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        //Build Tree
        for(int i=0;i<B.length;i++){
            adj.get(B[i][0]).add(B[i][1]);
        }
        // Initialize values array (all 1s initially)
        values = new int[A + 1];
        values[1] = 1;
        //dfs_update(1, 0, 1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] query : C) {
            int type = query[0];
            int node = query[1];
            if(type == 1) {
                dfs_update(node, -1, 1);
            } else if(type == 2) {
                dfs_update(node, -1, 0);
            } else {
                ans.add(dfs_count(node, -1));
            }
        }
        //Convert result to array
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ZeroOneNode zon = new ZeroOneNode();
        int A = 7;
        int[][] B = {
                {1, 2},
                {1, 3},
                {2 ,4},
                {3, 5},
                {3, 6},
                {3, 7}
        };
        int[][] C = {
                {1, 1},
                {2, 3},
                {3, 3},
                {3, 1}
        };
        int[] ans = zon.solve(A, B, C);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
