/**
 * 
 */
package backtracking;

import java.util.ArrayList;

/**
 * Problem Description:
Given a string A, partition A such that every string of the partition is a palindrome.
Return all possible palindrome partitioning of A.

Problem Constraints:
1 <= len(A) <= 15

Input Format
First argument is a string A of lowercase characters.

Output Format
Return a list of all possible palindrome partitioning of s.

Example Input
Input 1:

A = "aab"
Input 2:

A = "a"

Example Output
Output 1:

 [
    ["a","a","b"]
    ["aa","b"],
  ]
Output 2:

 [
    ["a"]
  ]
 *
 */
public class PalindromePartitioning {

	/**
	 * Intuition:
        Generate all the substrings using recursion and check if they are palindrome or not.If not Backtrack form there. Recursively traverse over the string.
        Solution Approach:
        
1.Create a function called "checkPalindrome" that takes in a string, start index and end index as parameters. This function checks if the substring of the string from start index to end index is a palindrome or not.
2.Create a function called "palindromePartition" that takes in an index, a vector of strings, a 2D vector of strings, and a string as parameters. This function partitions the given string into all possible palindrome partitions.
3.In the "palindromePartition" function, check if the current index is equal to the length of the string. If it is, add the current partition to the output vector and return.
4.Iterate from the current index to the end of the string.
5.For each iteration, check if the substring from current index to the current iterator is a palindrome using the "checkPalindrome" function.
6.If it is a palindrome, add it to the partition vector and recursively call the "palindromePartition" function with the updated partition and the next index.
7.After the recursive call, remove the last element from the partition vector.
8.Return the output vector after all partitions have been found.
	 */
	
	
	public static boolean checkPalindrome(String str, int startIndex, int endIndex) {
		while (startIndex <= endIndex) {
			if (str.charAt(startIndex) != str.charAt(endIndex))
				return false;
			startIndex++;
			endIndex--;
		}
		return true;
	}

	public static void palindromePartition(int index, ArrayList<String> temp, ArrayList<ArrayList<String>> ans, String str) {
		if (index == str.length()) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < str.length(); i++) {
			if (checkPalindrome(str, index, i)) {
				temp.add(str.substring(index, i + 1)); // do the change
				palindromePartition(i + 1, temp, ans, str); //recursive call
				temp.remove(temp.size() - 1);//undo the change
			}
		}
	}
	
	public static ArrayList<ArrayList<String>> partition(String str) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		palindromePartition(0, temp, ans, str);
		return ans;
	}
    
	
	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));

	}

}
