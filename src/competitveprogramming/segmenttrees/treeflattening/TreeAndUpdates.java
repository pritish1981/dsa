package competitveprogramming.segmenttrees.treeflattening;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Problem Description

Given an undirected tree with N nodes which is rooted at node 1. The ith node has A[i] value assign to it.

You are asked to perform Q queries of two types:

1 X Y: Change the value of all nodes in the subtree of the node X to the value Y.
2 X F: Find the number of distinct value in the subtree of the node X.
NOTE: Subtree of Node X should also include the node X.

Problem Constraints
2 <= N, Q <= 10^5
2 <= X, B[i][0], B[i][1] <= N
1 <= A[i], Y <= 60
F = 0 (Not for any use)

Input Format

First argument is an integer array A of size N denoting the value of nodes.

Second argument is a 2D array B of size (N-1) x 2 denoting the edges in the tree. ith edge is between B[i][0] and B[i][1] nodes.

Third argument is a 2D array C of size Q x 3 denoting queries where C[i][0] denotes the type of query.

If C[i][0] == 1, C[i][1] denotes X and C[i][2] denotes Y

If C[i][0] == 2, C[i][1] denotes X.

Output Format

Return an integer array denoting the output of query of type 2.

Example Input :

 A = [1, 1, 3]
 B = [
       [1, 2]
       [1, 3]
     ]
 C = [
       [2, 1, 0]
       [1, 1, 2]
       [2, 1, 0]
     ]
Output : [2, 1]

Explanation :

 Given Tree:       1(1)
                  / \
              (1)2   3(3)
 Initial Node value denoted in brackets.
 First query: Distinct node in subtree of node 1 i.e 2.
 Second query: All nodes will have value 2.
 Third query: Only 1 distinct value in subtree of node 1.
 */
public class TreeAndUpdates {
    ArrayList<ArrayList<Integer>> adj;
    static class SegmentTreeNode {
        SegmentTreeNode left, right;
        int start, end;
        Set<Integer> values;
        int lazyValue;
        boolean lazy;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.values = new HashSet<>();
            this.lazyValue = -1;
            this.lazy = false;
        }
    }

    private SegmentTreeNode build(int[] A, int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.values.add(A[start-1]);
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        node.values.addAll(node.left.values);
        node.values.addAll(node.right.values);
        return node;
    }

    private void propagate(SegmentTreeNode node) {
        if (node.left != null) {
            node.left.values.clear();
            node.left.values.add(node.lazyValue);
            node.left.lazyValue = node.lazyValue;
            node.left.lazy = true;
        }
        if (node.right != null) {
            node.right.values.clear();
            node.right.values.add(node.lazyValue);
            node.right.lazyValue = node.lazyValue;
            node.right.lazy = true;
        }
        node.lazy = false;
    }

    private void update(SegmentTreeNode node, int start, int end, int value) {
        if (node.lazy) {
            propagate(node);
        }
        if (start > node.end || end < node.start) {
            return;
        }
        if (start <= node.start && node.end <= end) {
            node.values.clear();
            node.values.add(value);
            node.lazyValue = value;
            node.lazy = true;
            return;
        }
        update(node.left, start, end, value);
        update(node.right, start, end, value);
        node.values.clear();
        node.values.addAll(node.left.values);
        node.values.addAll(node.right.values);
    }

    private Set<Integer> query(SegmentTreeNode node, int start, int end) {
        if (node.lazy) {
            propagate(node);
        }
        if (start > node.end || end < node.start) {
            return new HashSet<>();
        }
        if (start <= node.start && node.end <= end) {
            return node.values;
        }
        Set<Integer> leftValues = query(node.left, start, end);
        Set<Integer> rightValues = query(node.right, start, end);
        leftValues.addAll(rightValues);
        return leftValues;
    }

    public int[] solve(int[] A, int[][] B, int[][] C) {
        int n = A.length;
        // Initialize adjacency list List>
        adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build adjacency list
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize in-time and out-time arrays
        int[] inTime = new int[n + 1];
        int[] outTime = new int[n + 1];
        int[] time = {0};
        dfs(1, 0, adj, inTime, outTime, time);

// Build Segment Tree
        SegmentTreeNode root = build(A, 1, n);

        List<Integer> result = new ArrayList<>();
        for (int[] query : C) {
            if (query[0] == 1) {
                // Update query
                update(root, inTime[query[1]], outTime[query[1]], query[2]);
            } else {
                // Count distinct values query
                Set<Integer> distinctValues = query(root, inTime[query[1]], outTime[query[1]]);
                result.add(distinctValues.size());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] inTime, int[] outTime, int[] time) {
        inTime[node] = ++time[0];
        for (int child : adj.get(node)) {
            if (child != parent) {
                dfs(child, node, adj, inTime, outTime, time);
            }
        }
        outTime[node] = ++time[0];
    }
}
