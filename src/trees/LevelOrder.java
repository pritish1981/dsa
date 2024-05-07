/**
 * 
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pritish
 *
 */
public class LevelOrder {

	Node root;

	public void levelOrder() {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
           	int size = q.size();
			for (int i = 1; i <= size; i++) {
				Node temp = q.poll();
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				
			}
			
          System.out.println();
		}
	}
	public void createBinaryTree() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		root = first;
		first.left = second;
		first.right = third;
		second.left = four;
		second.right = five;
		third.left = six;
		third.right = seven;
	}
	public static void main(String[] args) {
		LevelOrder lo = new LevelOrder();
		lo.createBinaryTree();
		lo.levelOrder();
		
	}

}
