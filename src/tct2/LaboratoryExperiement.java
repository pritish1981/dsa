package tct2;

import java.util.ArrayList;

/*
There is a laboratory containing N rats and they are doing an experiment over them.
There is an array A of size M*2 showing A[i][0] and A[i][1] belongs to the same family.There is also an array B of size N showing the
cost of giving vaccine to the ith rat. They have to give vaccine to at-least one member of each family.Find the minimum cost required to
provide vaccine in this way.
Note: A[i][0] and A[i][1] can be equals also.

Problem Constraints:
0<= |A|<=10^5
1 <= |B| <= 10^5
0 <= B[i] <= 10^4
1 <= A[i][0] <= |B|
1 <= A[i][1] <= |B|

Example Input:
Input 1: A = [[1,2],[2,3],[3,4]], B = [2,4,3], Output: 2
Input 2: A = [[1,2]], B = [1,2,3,4,5,6,7,8], Output: 34
 */
public class LaboratoryExperiement {

    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static int min;

    public static int minimumCost(int[][] families, int[] costs) {
        int n = costs.length;
        vis = new boolean[n + 1];
        g = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] family : families) {
            int u = family[0];
            int v = family[1];
            if (u == v) {
                continue;
            }
            g[u].add(v);
            g[v].add(u);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                min = Integer.MAX_VALUE;
                dfs(i, costs);
                ans += min;
            }
        }
        return ans;
    }

    static void dfs(int u, int[] costs) {
        vis[u] = true;
        min = Math.min(min, costs[u - 1]);
        for (int v : g[u]) {
            if (!vis[v]) {
                dfs(v, costs);
            }
        }
    }
    public static void main(String[] args) {
        int[][] families = {{1, 2}, {2, 3}, {3, 4}};
        int[] costs = {2, 4, 3, 1};
        int minCost = minimumCost(families, costs);
        System.out.println("Minimum cost: " + minCost);
    }
}
