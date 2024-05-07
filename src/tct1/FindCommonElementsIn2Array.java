package tct1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindCommonElementsIn2Array {
	
	public static int[] solve(int[] A, int[] B) {
        //the maximum no of common elements can be of min-length(A & B)
		int[] common = new int[Math.min(A.length, B.length)];
		int count = 0;// no of common elements
		//Get frequency of all elements in Array A in a HashMap
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<A.length;i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i])+1);
			}else {
				map.put(A[i], 1);
			}
		}
		//for each element in Array B , check if it is present in the map or not
		for(int i=0;i<B.length;i++) {
			// if the element is present in the map reduce the frequency by 1 & increase the count of array by 1
			if(map.containsKey(B[i])) {
				int freq = map.get(B[i]);// frequency of B[i] in array A
				common[count] = B[i];
				count++;
				//if the frequency was 1 it was the last element in Array A & remove it.
				if(freq == 1) {
					map.remove(B[i]);
				}else {
					// if the frequency is ore than 1 reduce by 1
					map.put(B[i], (freq-1));
				}
			}
		}
		// No common elements
		if (count == 0) return new int[] {};
		//the number of common elemnts is equal to count
		int[] arr = new int[count];
		for(int i=0;i<arr.length;i++) {
			arr[i] = common[i];
		}
	     return arr;
	}
	
	
	public static void main(String[] args) {
		int[] A = {4,3,2,3,1};
		int[] B = {2,2,5,2,3,6};
		int[] ans = solve(A,B);
		int[] C = {1,2,2,1};
		int[] D = {2,3,1,2};
		int[] sol = solve(C,D);
		System.out.println("common elements between 2 arrays :: "+Arrays.toString(ans));
		System.out.println("common elements between 2 arrays, C & D is  :: "+Arrays.toString(sol));

	}

}
