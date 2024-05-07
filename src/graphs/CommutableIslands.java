/**
 * 
 */
package graphs;

import java.util.Arrays;

/**
 * Problem Description
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format
The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format
Return an integer representing the minimal cost required.



Example Input
Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]


Example Output
Output 1:  6
Output 2:  6


Example Explanation
Explanation 1:

 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
Explanation 2:

 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 *
 */
public class CommutableIslands {
	//By using Kruskal Algorithm
	static int[] parent;
	static int[] rank;

	public static int solve(int A, int[][] B) {
		// B[i] = [x,y,cost]
		// sort the edges based on minimum weight
		Arrays.sort(B, (a, b) -> a[2] - b[2]); 

		parent = new int[A + 1];
		rank = new int[A + 1];

		for (int i = 1; i <= A; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		int cost = 0;
		int num_edges = 0;

		// select edges one by one if(u,v) doesn't belong to the same set, add in the MST cost.
		for (int[] connection : B) {
			if (union(connection[0], connection[1])) {
				cost += connection[2];
				num_edges++;
			}
		}
		return num_edges == A - 1 ? cost : -1;
	}

	public static boolean union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if (rx == ry) return false;
		if (rank[rx] > rank[ry])  parent[ry] = rx;
		else if (rank[ry] > rank[rx]) parent[rx] = ry;
		else {
			  parent[ry] = rx;
			  rank[rx]++;
		   }
		return true;
	}

	public static int find(int x){
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
	
	// Time Complexity: O(E log E), Space Complexity: O(N+E)

	public static void main(String[] args) {
		int N = 3;
		int connections[][] = { { 1, 2, 5 }, { 1, 3, 6, }, { 2, 3, 1 } };
		System.out.println("Minimum costs to connect all islands :: " + solve(N, connections));

	}

}
