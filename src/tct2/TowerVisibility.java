package tct2;
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
        int maxVisibleTowers = 0;
        int closestPosition = 0;

        for (int i = 0; i < n; i++) {
            int visibleTowers = 0;
            int currentHeight = heights[i];

            // Count visible towers to the right of the current tower
            for (int j = i + 1; j < n; j++) {
                if (heights[j] > currentHeight) {
                    visibleTowers++;
                    currentHeight = heights[j];
                }
            }

            // Update the closest position with the maximum number of visible towers
            if (visibleTowers > maxVisibleTowers) {
                maxVisibleTowers = visibleTowers;
                closestPosition = i;
            }
        }

        return closestPosition + 1; // Convert 0-based index to 1-based position
    }

    public static void main(String[] args) {
        int[] heights = {153, 199, 301, 245};
        int position = closestPositionWithMaxVisibility(heights);
        System.out.println("Closest position with maximum visibility: " + position);
    }



}
