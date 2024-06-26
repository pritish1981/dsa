/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 <= xi, yi <= 104
 *
 */
public class KClosestPointsToOrigin {

	 public static int[][] kClosest(int[][] points, int k) {
	        int n = points.length;
	        Point[] p = new Point[n];
	        for(int i=0;i<n;i++){
	            int x = points[i][0];
	            int y= points[i][1];
	            int d = (x * x) + (y * y);
	            p[i] = new Point(x,y,d);
	        }
	        PointComparator pc = new PointComparator();
	        Arrays.sort(p, pc);

	        int[][] ans = new int[k][2];
	        for(int i=0;i<k;i++){
	            ans[i][0] = p[i].x;
	            ans[i][1] = p[i].y;
	        }
	        return ans;
	    }


	    static class PointComparator implements Comparator<Point>{
	        public int compare(Point p1, Point p2){
	            if(p1.d > p2.d) return 1;
	            else if(p1.d < p2.d) return -1;
	            else return 0;
	        }
	    }
	    static class Point{
	        int x, y, d;
	        Point(int x, int y,int d){
	            this.x = x;
	            this.y = y;
	            this.d = d;
	        }
	    }
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k = 2;
		
		System.out.println("K closest points to origin is::" + kClosest(points, k));

	}

}
