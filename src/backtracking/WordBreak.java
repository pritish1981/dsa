/**
 * 
 */
package backtracking;

import java.util.ArrayList;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class WordBreak {
	public static boolean wordBreak(String s, ArrayList<String> wordDict) {
		if (s == null && wordDict == null)
			return true;
		if (s == null || wordDict == null)
			return false;
		// dp[i] represents if s.substring(0, i+1) is wordbreakable.
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		String A = "myinterviewtrainer";
		ArrayList<String> B = new ArrayList<>();
		B.add("trainer");
		B.add("my");
		B.add("interview");
		System.out.println(wordBreak(A, B));

	}

}
