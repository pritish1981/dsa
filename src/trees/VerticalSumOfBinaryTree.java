package trees;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
You are given the root of a binary tree A.
You have to find the vertical sum of the tree.
A vertical sum denotes an array of sum of the different verticals of a binary tree,
where the leftmost vertical sum is the first element of the array and rightmost vertical is the last.

Problem Constraints
1 <= Number of nodes in the binary tree <= 105
1 <= Ai <= 10^3

Input Format
The first argument is the root of a binary tree A.

Output Format
Return an array denoting the vertical sum of the binary tree.

Example Input
Input 1:
A =     1
      /   \
     2     3
    / \   / \
   4   5 6   7
Input 2:

A =     1
       /
      2
     /
    3


Example Output
Output 1:
[4, 2, 12, 3, 7]
Output 2:

[3, 2, 1]

 */
public class VerticalSumOfBinaryTree {
    static TreeNode root;
    static TreeMap<Integer, Integer> map;

public static int[] verticalSum(TreeNode root){
  map = new TreeMap<>();
  rec(root, 0);
  int[] ans = new int[map.size()];
  int cur = 0;
  for(Map.Entry<Integer, Integer> e : map.entrySet()){
      ans[cur++] = e.getValue();
  }
  return ans;
}

public static void rec(TreeNode root, int HD){
 if(root == null) return;
 map.putIfAbsent(HD, 0);
 map.put(HD, map.get(HD) + root.val);
 rec(root.left, HD - 1);
 rec(root.right, HD + 1);
}

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] ans = verticalSum(root);
        System.out.println("Vertical sum of nodes in a binary tree:: "+Arrays.toString(ans));
    }
}
