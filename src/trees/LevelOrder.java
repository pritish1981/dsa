/**
 * 
 */
package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Pritish
 *
 */
public class LevelOrder {

	Node root;

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
			
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
           	int levelSize = q.size();
			   List<Integer> level = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				Node node = q.poll();
				level.add(node.data);
				if(node.left != null) q.add(node.left);
				if(node.right != null) q.add(node.right);
			}
			result.add(level);
		}
		return result;
	}
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		LevelOrder levelOrderTraversal = new LevelOrder();
		List<List<Integer>> result = levelOrderTraversal.levelOrder(root);
		// Print the level order traversal result
		System.out.println("Level order traversal:");
		for (List<Integer> level : result) {
			System.out.println(level);
		}
	}

}
