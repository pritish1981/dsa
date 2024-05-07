/**
 * 
 */
package trees;

import java.util.*;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. 
The root of the tree is at (0, 0).The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from 
the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.

        3(0,0)
       / \
 (1,-1)9   20 (1,1)
           / \
   (2,-2)15  7(2,2)
        
        
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
 *
 */
public class VerticalOrder {
	static Node root;

	static class Pair{
		int verticalLevel;
		Node node;
		public Pair(int hd, Node node) {
			super();
			this.verticalLevel = hd;
			this.node = node;
		} 
		
	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;

		// hm <level, nodes>
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, root));
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			Pair curPair = q.poll();
			Node curNode = curPair.node;
			int curNodelevel = curPair.verticalLevel;

			min = Math.min(min, curNodelevel);
			max = Math.max(max, curNodelevel);

			// add currNode in hm
			if (!map.containsKey(curNodelevel)) {
				map.put(curNodelevel, new ArrayList<>());
			}

			ArrayList<Integer> list = map.get(curNodelevel);
			list.add(curNode.data);
			map.put(curNodelevel, list);

			if (curNode.left != null) {
				q.add(new Pair(curNodelevel - 1, curNode.left));
			}

			if (curNode.right != null) {
				q.add(new Pair(curNodelevel + 1, curNode.right));
			}
		}
		while (min <= max) {
			ans.add(map.get(min++));
		}

		return ans;
	}
	
	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);

		verticalOrder(root);
		System.out.println(verticalOrder(root));

	}

}
