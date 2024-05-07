/**
 * 
 */
package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Alice visited the land of Amusement parks. There are total of A amusement parks numbered from 1 to A.Some amusement parks are
 * connected to each other by bidirectional  bridges given by array B. Alice standing at amusement park 1 and wants to reach 
 * amusement park A. Find the minimum number of bridges that he shall have to cross, if he takes the optimal route.
 * Return -1 if it is not possible to reach amusement park A.
 * 
 * Constraints:
 * 1<=A<=10^4
 * 1<=B.size()<=10^5
 * 
 *
 */
public class AliceAndParks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A = 4;
		int B[][] = {{1,2},{2,4},{1,3}};
		System.out.println("No. of bridges Alice needs to cross to reach Amusement park A is :: "+solve(A,B));

	}
	
	public static int solve(int A, int[][] B) {
        int visited[] = new int [A+1];
        visited[1] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while(q.size() > 0){
            int rn = q.poll();
            for(int i=0;i<B.length;i++){
                int a = B[i][0], b = B[i][1];
                if(a == rn && visited[b] == 0){
                    visited[b] = visited[a] + 1;
                    q.add(b);
                }else if(b == rn && visited[a] == 0){
                    visited[a] = visited[b] + 1;
                    q.add(a);
                }
            }
        }
        return visited[A]-1;
    }

}
