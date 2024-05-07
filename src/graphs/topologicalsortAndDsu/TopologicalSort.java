/**
 * 
 */
package graphs.topologicalsortAndDsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 10^4
1 <= M <= min(100000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

Example Input
Input 1:

 A = 6
 B = [  [6, 3] 
        [6, 1] 
        [5, 1] 
        [5, 2] 
        [3, 4] 
        [4, 2] ]
Input 2:

 A = 3
 B = [  [1, 2]
        [2, 3] 
        [3, 1] ]


Example Output
Output 1: [5, 6, 1, 3, 4, 2]
Output 2: []


Example Explanation
Explanation 1:

 The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
Explanation 2:

 The given graph contain cycle so topological ordering not possible we will return empty array.
 *
 */
public class TopologicalSort {

	static int maxn = 10009;
	static int[] in = new int[maxn]; //indegree
	static ArrayList<ArrayList<Integer>> adj; //adjacency list

	public static void graph() {
		adj = new ArrayList<ArrayList<Integer>>(maxn);
		for (int i = 0; i < maxn; i++) {
			in[i] = 0;
			adj.add(new ArrayList<Integer>());
		}
	}

	public static int[] solve(int A, int[][] B) {
		graph();
		// step1: Find indegree of all the nodes
		for (int[] edge : B) {
			adj.get(edge[0]).add(edge[1]);
			in[edge[1]]++;
		}
		// step2: insert all the indegree of 0 to queue
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < A; i++) {
			if (in[i] == 0)
				q.add(i);
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		// step3: Remove an element from queue & update the indegree of all of it's neighbours
		while (!q.isEmpty()) {
			int temp = q.poll();
			ans.add(temp);
			for (int nbr : adj.get(temp)) {
				in[nbr]--;
				// if indegree of any neighbours becomes 0 add that nbr to queue
				if (in[nbr] == 0)
					q.add(nbr);
			}
		}

		if (ans.size() != A)
			ans.clear();
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}
	//Time Complexity: O(N+E),Space Complexity: O(N)

	public static void main(String[] args) {
		int A = 6;
		int[][] B = { { 6, 3 }, { 6, 1 }, { 5, 1 }, { 5, 2 }, { 3, 4 }, { 4, 2 } };
		
		int C = 3;
		int [][] D = {{1,2},{2,3},{3,1}};
		int[] ans = solve(A, B);
		
		int[] res = solve(C,D);
		System.out.println("Topological sort::" + Arrays.toString(ans));
		System.out.println("Topological sort 1::" + Arrays.toString(res));
		
		
	}

}
