/**
 * 
 */
package tct1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

Constraints:

1 <= s.length <= 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 *
 */

/*
 * Intuition
1. We employ a sliding window approach to identify concatenated substrings within s.
2. Maintain a fixed-size window, equivalent to the combined length of all words in the words array.
3. Track the frequency of each word within the window and compare it to the frequencies in the words array.
4. If the window contains a valid permutation of words, we append the starting index of the window to the result list.
5. Incrementally shift the window one step at a time, examining all possible starting indices in s.

Approach :: 
We follow these steps to find the concatenated substrings:

1.Initialize a HashMap named hm to store the frequency of each word in the words array.

2.Calculate wordSize, which represents the length of each word in the words array, and windowSize, which signifies the total length of all words concatenated together.

3.Iterate through the string s from index 0 to s.length() - windowSize. This range ensures that we explore each potential starting index for the window.

4.In each iteration, create a new HashMap named map initialized with wordMap. It keeps track of word frequencies within the current window. We also initialize left as the current index and match as 0.

5.Employ a nested loop starting from right (current index) to right + windowSize - wordSize. In each iteration, extract a word of length wordSize from the current position.

6.Check if the extracted word exists in map (i.e., it is part of the words). If it does, decrement its frequency in map. If the frequency reaches 0, increment match.

7.When match equals the size of map, it signifies that all words from words are present in the current window, and we add left (the starting index) to the result list. We then break from the loop, as the inner loop ensures that the window contains a valid permutation.

8.Iterate through all possible starting indices in s, checking each window for concatenated substrings.

9.The inner HashMap map is crucial because it resets the word frequencies for each window. After the inner loop, map contains the original frequencies from hm for the next window.
 */
public class ConcatenationSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String word[] = { "foo", "bar" };
		List<Integer> indices = findSubstring(s, word);
		for (Integer i : indices) {
			System.out.println(i);
		}

	}
	
	public static List<Integer> findSubstring(String s, String[] words){
		List<Integer> ans = new ArrayList<>();
		int wordSize = words[0].length();
		int windowSize = words.length * wordSize;
		
		// create a hashmap to store the frequency of each word in the words array
		HashMap<String, Integer> hm = new HashMap<>();
		for(String w: words) {
			hm.put(w, hm.getOrDefault(w, 0)+1);
		}
		//Iterate through the string s from index 0 to s.length()-windowSize
		for(int i=0;i<s.length() - windowSize;i++) {
			//create a new hashMap for each window to track word frequencies
			HashMap<String, Integer> map = new HashMap<>(hm);
			int left = i; // Initialize left pointer for window
			int match = 0; // Keep track of matching words in the window
			//Iterate through the window word by word
			for(int j=i;j<= i+windowSize-wordSize;j+=wordSize) {
				//extract the current word from the window
				String word = s.substring(j, j+wordSize);
				//Check if word exists in the map
				if(map.containsKey(word)) {
					//decrement the frequency
					map.put(word, map.get(word)-1);
					//If frequency becomes zero increment the match count
					if(map.get(word) == 0) {
						match++;
					}
				}
				//If all words match in the window add left to the ans & break
				if(match == map.size()) {
					ans.add(left);
					break;
				}
			}
		}
		return ans;
	}

}
