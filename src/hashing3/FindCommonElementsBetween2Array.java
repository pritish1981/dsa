/**
 * 
 */
package hashing3;

import java.util.*;

/**
 * @author Pritish
 *
 */
public class FindCommonElementsBetween2Array {

	public static void findCommonElements(int[] A, int[] B) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		//Adding elements from A[]
		for(int i: A) {
			set1.add(i);
		}
		//Adding elements from B[]
		for(int i :B) {
			set2.add(i);
		}
		set1.retainAll(set2);
		System.out.println("Common elements- " + set1);
	}
	
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
		for (int x : A) {
			a.put(x, a.getOrDefault(x, 0) + 1);
		}
		for (int x : B) {
			b.put(x, b.getOrDefault(x, 0) + 1);
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int k : a.keySet()) {
			if (b.containsKey(k)) {
				for (int i = 0; i < Math.min(a.get(k), b.get(k)); ++i) {
					ans.add(k);
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// create Array 1
        int[] arr1  = { 1,2,2,1};
        // create Array 2
        int[] arr2 = { 2,3,1,2 };
 
        // print Array 1
        System.out.println("Array 1: "
                           + Arrays.toString(arr1));
        // print Array 2
        System.out.println("Array 2: "
                           + Arrays.toString(arr2));
        //findCommonElements(arr1, arr2);
        
        //findCommonElemntsin2Array(A,B);
        ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(1);
		ArrayList<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(3);
		B.add(1);
		B.add(2);
		solve(A,B);
		System.out.println(solve(A,B)+ "");
	}

}
