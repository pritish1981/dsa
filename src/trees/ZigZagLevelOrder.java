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
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		boolean zigzag = false;
		while(!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> level = new ArrayList<>();
			for(int i=0;i<levelSize;i++){
				Node node = q.poll();
				if(zigzag){
					level.add(0,node.data );// Add to the beginning of the list for zigzag
				}
				else{
					level.add(node.data);// Add to the end of the list for regular order
				}
				if(node.left != null) q.add(node.left);
				if(node.right != null) q.add(node.right);
			}
			result.add(level);
			zigzag = !zigzag;
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
