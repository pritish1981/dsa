/**
 * 
 */
package trees;

import java.util.*;

/**
 * @author Pritish
 *
 */
public class ZigZagLevelOrder {
	static Node root;
   //using queue
	static List<List<Integer>> zigzagLevelOrder(Node root){
		if(root == null) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		boolean reverseLevel = false;
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			while(size-- > 0) {
				root = q.poll();
				level.add(root.data);
				if(root.left != null) q.add(root.left);
				if(root.right != null) q.add(root.right);
			}
			if(reverseLevel) Collections.reverse(level);
			result.add(level);
			reverseLevel = !reverseLevel;
		}
		return result;
	}
	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.right.left = new Node(12);
		root.right.right = new Node(15);
		System.out.println("Zigzag level order traversal::"+zigzagLevelOrder(root));

	}

}
