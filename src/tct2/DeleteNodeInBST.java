/**
 * 
 */
package tct2;

/**
 * Given a BST, the task is to delete a node in this BST.
 *
 */
public class DeleteNodeInBST {

	/**
	 * @param args
	 */
	class Node {
	    int data;
	    Node left, right;
	 
	    // A utility function to create a new BST node
	    Node(int item) {
	        data = item;
	        left = right = null;
	    }
	}
	
	Node root;
	 
    // A utility function to do inorder traversal of BST
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    /* A utility function to insert a new node with given key in  BST */
    Node insert(Node node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);
 
        /* Otherwise, recur down the tree */
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
 
        /* return the (unchanged) node pointer */
        return node;
    }
    
    /* Given a binary search tree and a key, this function
    deletes the key and returns the new root */
	Node deleteNode(Node root, int key) {
		// Base case
		if (root == null)
			return root;

		// Recursive calls for ancestors of node to be deleted
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
			//return root;
		} else if (key > root.data) {
			root.right = deleteNode(root.right, key);
			//return root;
		}
		else {//if the key is equal to the root value
			//case1: in case of leaf node
			if(root.left == null && root.right == null)
				return null;
			//case 2: in case of one child, replace the root with child
			else if(root.left ==null) {
				root = root.right;
			}
			else if(root.right == null) {
				root = root.left;
			}
			// Case 3: If the node has two children, we find the inorder successor of the node, 
            // which is the node with the smallest value in the right subtree. We then replace 
            // the value of the root with the value of the inorder successor, and recursively 
            // delete the inorder successor node from the right subtree.
			
			else {
				Node successor = findMin(root.right);
				root.data = successor.data;
				root.right = deleteNode(root.right, successor.data);
			}
			
		}
		  return root;
		}
	
	static Node findMin(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	

	public static void main(String[] args) {
		DeleteNodeInBST tree = new DeleteNodeInBST();
		
		/* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		
		tree.root = tree.insert(tree.root, 50);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 40);
		tree.insert(tree.root, 70);
		tree.insert(tree.root, 60);

		System.out.print("Original BST: ");
		tree.inorder(tree.root);

		System.out.println("\n\nDelete a Leaf Node: 20");
		tree.root = tree.deleteNode(tree.root, 20);
		System.out.print("Modified BST tree after deleting Leaf Node:\n");
		tree.inorder(tree.root);

		System.out.println("\n\nDelete Node with single child: 70");
		tree.root = tree.deleteNode(tree.root, 70);
		System.out.print("Modified BST tree after deleting single child Node:\n");
		tree.inorder(tree.root);

		System.out.println("\n\nDelete Node with both child: 50");
		tree.root = tree.deleteNode(tree.root, 50);
		System.out.print("Modified BST tree after deleting both child Node:\n");
		tree.inorder(tree.root);

	}

}
