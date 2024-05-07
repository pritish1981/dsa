/**
 * 
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Difference between sums of odd level and even level nodes of a Binary Tree
 *
 */
class Node{
	int data;
	Node left;
	Node right;
	Node (int data){
		this.data = data;
		left = null;
		right = null;      
	}
}
public class SumOfOddEvenLevel {
	
	
	static Node root;

	public static  int oddEvenSum(Node root) {
        if (root == null) return 0;
		//create a queue for level order traversal
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int level = 0, evenSum = 0, oddSum = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			level++;
			//traverse for complete level
			while(size > 0 ) {
				Node temp = q.poll();
				//check if level no. is odd or even update the even sum or odd sum accordingly
				if(level %2 == 0)
					evenSum += temp.data;
				else 
					oddSum += temp.data;
				//check for left child
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
				size--;
			}
		}
		return(oddSum - evenSum);
    }
	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.right.left = new Node(12);
		root.right.right = new Node(15);
		
		oddEvenSum(root);
		System.out.println(oddEvenSum(root));

	}

}
