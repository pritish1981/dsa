/**
 * 
 */
package queues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Problem Description
Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.

Problem Constraints
1 <= |A|, B <= 10^6

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Example Input
Input 1:

 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
Input 2:

 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6


Example Output
Output 1:

 [3, 3, 5, 5, 6, 7]
Output 2:

 [7, 7, 7, 7]


Example Explanation
Explanation 1:

 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7
Explanation 2:

 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7
 
 
 Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Using Deque: 
Window position				 Max   Deque
---------------				 ---   ������
 i=0
[1] 3  -1  -3  5  3  6  7		    -	        1. if first index in Q(deque) < i-k+1 ? no-> so no poll()
									-			2. loop: nums[i] > last element of the Q(Deque)? no -> so no pollLast()
									1(0)		3. offer(i)
							  -		1(0)		4. (i >= k - 1) no -> [window is incomplete].
	i=1								
[1  3] -1  -3  5  3  6  7			1(0)		1. if first index in Q(deque) < i-k+1 ? no-> so no poll) 
	   								-			2. loop: nums[i] > last element of the Q(Deque)? yes->so pollLast() -> 1(0) polled
									3(1)    	3. offer(i)
							  -		3(1)	    4. (i >= k - 1) no -> [window is incomplete]. 
	   i=2
[1  3  -1] -3  5  3  6  7			3(1)		1. if first index in Q(deque) < i-k+1 ? no-> so no poll() 
									3(1)		2. loop : nums[i] > last element of the Q(Deque)? no -> so no pollLast()
									3(1),-1(2)	3. offer (i)	
							  3		3(1),-1(2)	4. (i >= k - 1) yes -> output q.peek();
		  i=3					    	
 1 [3  -1  -3] 5  3  6  7 			3(1),-1(2)  1. if first index in Q(deque) < i-k+1 ? no-> so no poll() 
									3(1),-1(2)	2. loop: nums[i] > last element of the Q(Deque)? no-> so no poll() 
									3(1),-1(2),-3(3)	3. offer(i)
							  3		3(1),-1(2),-3(3)	4. (i >= k - 1) yes -> output q.peek();
			  i=4
 1  3 [-1  -3  5] 3  6  7			-1(2),-3(3)   	1. if first index in Q(deque) < i-k+1 ? yes-> so poll() -> 3(1) polled 
									-			2. loop: nums[i] > last element of the Q(Deque)? yes -> so pollLast() -> -3(3) polled, -1(2) polled
									5(4)		3. offer(i)
							  5		5(4)		4. (i >= k - 1) yes -> output q.peek();
			     i=5	
 1  3  -1 [-3  5  3] 6  7			5(4)		1. if first index in Q(deque) < i-k+1 ? no-> so no poll() 
									5(4)		2. loop: nums[i] > last element of the Q(Deque)? no -> so no pollLast()
									5(4),3(5)	3. offer(i)
							  5		5(4),3(5)	4. (i >= k - 1) yes -> output q.peek();
			        i=6		
 1  3  -1  -3 [5  3  6] 7			5(4),3(5)	1. if first index in Q(deque) < i-k+1 ? no-> so no poll() 
									�			2. loop: nums[i] > last element of the Q(Deque)? yes -> so pollLast() -> 3(5) & 5(4) polled
									6(6)		3. offer(i)
							  6		6(6)		4. (i >= k - 1) yes -> output q.peek();

 1  3  -1  -3  5 [3  6  7]    7		...
 *
 */
public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (nums == null || n <= 0)
			return new int[0];
		if (k > n)
			return new int[0];

		// store results
		int ans[] = new int[n - k + 1];
		Deque<Integer> dq = new LinkedList<Integer>();
		int idx = 0;

		for (int i = 0; i < n; i++) {
			// 1. if first index in Q(Deque) < i-k+1
			if (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}
			// 2. loop: nums[i] > last element of the Q(Deque)?
			while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
				dq.pollLast();
			}
			// 3. offer(i)
			dq.offer(i);
			// 4.if window is complete then ouput nums[peek()]
			if (i - k + 1 >= 0) {
				ans[idx++] = nums[dq.peek()];
			}
		}
		return ans;
		// TC: O(N) | SC: O(K)
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int B = 3;
		int[] ans = maxSlidingWindow(A, B);
		System.out.println(Arrays.toString(ans));

	}

}
