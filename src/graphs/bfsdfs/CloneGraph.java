/**
 * 
 */
package graphs.bfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Pritish
 *
 */

class Node {
	int label;
	List<Node> neighbors;

	Node(int x) {
		label = x;
		neighbors = new ArrayList<Node>();
	}
};

public class CloneGraph {

	static HashMap<Node, Node> map;

	public static Node cloneGraph(Node node) {
		map = new HashMap<Node, Node>();
		return auxCloneGraph(node);
	}

	public static Node auxCloneGraph(Node node) {
		if (node == null)
			return node;
		if (map.containsKey(node)) {
			return map.get(node);
		}
		Node clone = new Node(node.label);
		map.put(node, clone);
		for (Node neighbor : node.neighbors) {
			clone.neighbors.add(auxCloneGraph(neighbor));
		}
		return clone;
	}

	public static void main(String[] args) {
		 Node node1 = new Node(1);
	        Node node2 = new Node(2);
	        Node node3 = new Node(3);
	        Node node4 = new Node(4);
	        node1.neighbors.add(node2);
	        node1.neighbors.add(node4);
	        node2.neighbors.add(node1);
	        node2.neighbors.add(node3);
	        node3.neighbors.add(node2);
	        node3.neighbors.add(node4);
	        node4.neighbors.add(node1);
	        node4.neighbors.add(node3);
	        Node node = cloneGraph(node1);
	        System.out.println(node);

	}

}
