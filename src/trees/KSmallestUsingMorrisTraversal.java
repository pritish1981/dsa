/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class KSmallestUsingMorrisTraversal {

	static int kSmallestUsingMorris(TreeNode root, int k) {
		int count = 0;
		int kSmall = Integer.MIN_VALUE;
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
				count++;
				if(count == k) {
					kSmall = curr.val;
				}
				curr = curr.right;
			}else {
				TreeNode temp = curr.left;
				while(temp.right != null && temp.right != curr) {
					temp = temp.right;
				}
				if(temp.right == null) {
					//create connection & go to left
					temp.right = curr;
					curr = curr.left;
				}else if(temp.right == curr) {
					//break the connection & print the node & go to right
					temp.right = null;
					count++;
					if(count == k) {
						kSmall = curr.val;
					}
					curr = curr.right;
				}
					
			}
		}
		return kSmall;
	}
	
	// A utility function to create a new BST node
	static TreeNode newNode(int item)
	{
	    TreeNode temp = new TreeNode(item);
	    temp.val = item;
	    temp.left = null;
	    temp.right = null;
	    return temp;
	}
	
	/* A utility function to insert a new node with given key in BST */
	static TreeNode insert(TreeNode node, int key)
	{
	    /* If the tree is empty, return a new node */
	    if (node == null) return newNode(key);
	 
	    /* Otherwise, recur down the tree */
	    if (key < node.val)
	        node.left = insert(node.left, key);
	    else if (key > node.val)
	        node.right = insert(node.right, key);
	 
	    /* return the (unchanged) node pointer */
	    return node;
	}
	
	public static void main(String[] args) {
		TreeNode root = null;
	    root = insert(root, 50);
	    insert(root, 30);
	    insert(root, 20);
	    insert(root, 40);
	    insert(root, 70);
	    insert(root, 60);
	    insert(root, 80);
	 
	    for (int k=1; k<=7; k++)
	    System.out.print(kSmallestUsingMorris(root, k) + " ");

	}

}
