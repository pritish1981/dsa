package tct2;
/*
Problem Description:
you are given a binary tree with N nodes. You have to minimize the maximum distance between any node and root of the tree.
In one operation , you can peak a leaf node and attach it to ay other node of the tree. The properties of the binary tree
should not be broken at any point of time during the operations.The cost of the one operation will be the value of the node
being picked.Find the minimum total cost to perform the task.

Problem Constraints:
1<=N<=10^5
1<=Value of Nodes<=10^3

Input Format: 1st argument is the root of the binary tree A
Output Format: Return the minimum total cost to perform the task.

Input1:
    1
   / \
  2   3
 /\
4  5
   /\
   11 7

Output: 18

Solution Approach:
For any given Tree minimum possible height will be ceil(log2(N+1)) where N is the number of nodes in the tree.
Any node with greater depth will have to be removed  and attached to the node with lesser height in the Tree.
First we will perform dfs to count the number of nodes in the Tree.
Then 2nd dfs to count the sum of the values of all the nodes greater than the maximum possible height.
Time Complexity: O(N)

 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class MinimizeHeight {

   static int h = 0, sum = 0;
   // Calculate the number of nodes in the Tree
    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        return left + right + 1;
    }

    public static void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
        if(height > h) {
            sum += root.val;
        }
        return;
    }
    public static int minHeight(TreeNode A){
        int n = count(A);
        h = (int) Math.ceil(Math.log(n + 1) / Math.log(2));
        dfs(A, 1);
        return sum;

    }

}
