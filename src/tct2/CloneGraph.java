package tct2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Clone an undirected graph. Each node in the Graph contains a label and a list of its neighbors.
Problem Constraint:
1<=Number of nodes<=10^5
 */

public class CloneGraph {
    private static final Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        // If the node was already visited before, return the clone from the visited map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        // Add the clone to the visited map
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        // Create a sample graph to test the cloneGraph function
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cg = new CloneGraph();
        UndirectedGraphNode clonedGraph = cg.cloneGraph(node1);

        // Print the cloned graph to verify
        System.out.println("Cloned node label: " + clonedGraph.label);
        for (UndirectedGraphNode neighbor : clonedGraph.neighbors) {
            System.out.println("Neighbor of cloned node: " + neighbor.label);
        }
    }
}
