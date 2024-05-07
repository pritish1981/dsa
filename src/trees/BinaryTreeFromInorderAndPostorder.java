/**
 * 
 */
package trees;

/**
 * @author Pritish
 *
 */
public class BinaryTreeFromInorderAndPostorder {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {
		}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode buildTree(int[] A, int[] B) {
        return build(A,0,A.length-1,B,0,B.length-1);
    }
    
    public TreeNode build(int[] A, int inS, int inE, int[] B, int posS, int posE){
        if(inS>inE || posS>posE) return  null;
        
        TreeNode root = new TreeNode(B[posE]);
        
        int rootI=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==root.val){
                rootI = i;
                break;
            }
        }
        
        root.left = build(A,inS,rootI-1,B,posS,posS+rootI-inS-1);
        root.right = build(A,rootI+1,inE,B,posS+rootI-inS,posE-1);
        
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
