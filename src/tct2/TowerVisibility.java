package tct2;

import java.util.Stack;

/*
There are N towers. They are given in the form of array A, where Ai represents the height of the ith tower.
Bowser will stand on the one of the towers and try to see the maximum possible number of towers from the position.
if at position i we look from i+1 and onwards. The towers are numbered from  1 to N.Help Bowser find the closest
position from where he can see the maximum number of towers.
Note:
-To see a tower from the ith tower, the tower has to be taller or of the same height and not hidden behind a taller tower.
-position x is closer compared to position y if x<y.

Problem Constraints:
1<=N<=10^5
1<=A[i]<=10^9

 */
public class TowerVisibility {
    public static int closestPositionWithMaxVisibility(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans = 1, max = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                st.pop();
            }
            if (st.size() >= max) {
                max = st.size();
                ans = i + 1;
            }
            st.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {153, 199, 301, 245};
        int position = closestPositionWithMaxVisibility(heights);
        System.out.println("Closest position with maximum visibility: " + position);
    }

}
