/**
 * 
 */
package tct1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 *
 */
public class RemoveRepeatingSubsequences {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 3, 4, 2, 3, 4, 5};
		//create a new array to store unique subsequences
		List<Integer> uniqueSubsequences = new ArrayList<>();
		//Iterate over original array
		for(int i=0;i<arr.length;i++) {
			//check if current subsequence is already present in the unique subsequence array
			if(!uniqueSubsequences.contains(arr[i])) {
				uniqueSubsequences.add(arr[i]);
			}
		}
       //print unique subsequences
		for(int i=0;i<uniqueSubsequences.size();i++) {
			System.out.print(uniqueSubsequences.get(i) + ",");
		}
	}
}
