/**
 * 
 */
package graphs.topologicalsortAndDsu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** LeetCode-207: https://leetcode.com/problems/course-schedule/
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 *
 */
public class CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] indegree = new int[numCourses];
		List<List<Integer>> adj = new ArrayList<>(numCourses);
		
        //add courses in the adjancency list
		
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}
		int m = prerequisites.length;
		for(int i=0;i<m;i++){
			adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
       //1. Find indegree of all the nodes
		for(int i=0;i<numCourses;i++){
			for(int node: adj.get(i))
				indegree[node]++;
		}
		

		//2. insert all the indegree of 0 to queue
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		//3.Remove an element from queue & update the indegree of all of it's neighbours(decrement indegree)
		int count = 0;
		List<Integer> topo = new ArrayList<>();
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			count++;

			for (Integer nbr : adj.get(temp)) {
				if (indegree[nbr] == 0) {
					queue.add(nbr);
				}
			}
		}
        if(topo.size() == numCourses)
			return true;
		return false;

	}

    //T.C: O(N+E), S.C = O(N)
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		System.out.println("Course schedule:: " + canFinish(numCourses, prerequisites));

	}

}
