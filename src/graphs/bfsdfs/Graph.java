package graphs.bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int V; // no of vertices
    private List<List<Integer>> adj; // adjacency list of graph

    // constructor
    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

    }
    // add edges to the graph
    public void insertEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    //BFS Traversal
    public void bfs(int src) {
        //Mark all the vertices as unvisited or false
        boolean visited[] = new boolean[V];
        //create a queue for BFS
        Queue<Integer> q = new LinkedList<>();
        //mark the current node as visited & add to the queue
        visited[src] = true;
        q.add(src);

        while(!q.isEmpty()) {
            src = q.poll();
            System.out.print(src +  " ");
            //Get all adjacent vertices of dequeued vertex
            for (int nbr : adj.get(src)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }

    //DFS Traversal
    public void dfs(int u) {
        boolean visited[] = new boolean[V];
        dfs_helper(u, visited);
    }
    void dfs_helper(int u, boolean visited[]) {
        visited[u] = true;
        System.out.print(u + " ");
        // checking for all nodes adjacent to u
        for (int nbr : adj.get(u)) {
            if (!visited[nbr]) {
                dfs_helper(nbr, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.insertEdge(0, 1);
        g.insertEdge(0, 3);
        g.insertEdge(1, 4);
        g.insertEdge(1, 2);
        g.insertEdge(2, 3);
        g.insertEdge(4, 5);
        g.insertEdge(4, 6);
        g.insertEdge(5, 6);
        System.out.println("The BFS traversal of the given graph starting from node 0 is " );
        g.bfs(0);
        System.out.println();
        System.out.println("The DFS traversal of the given graph starting from node 0 is -");
        g.dfs(0);
    }

}
