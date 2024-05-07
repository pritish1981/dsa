/**
 * 
 */
package dp.string;

/**
 * @author Pritish
 *
 */
public class LongestPalindromeInString {

	public static String longest_palindrome(String s) {
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		int max_pal_length = 1;
		// setting the value of substrings of length 1 to True in dp table (i.e. same character)
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		// for substrings of length 2
		int start = 0;
		for (int j = 0; j < n - 1; j++) {
			// checking if there are 2 consecutive characters that are same
			if (s.charAt(j) == s.charAt(j + 1)) {
				dp[j][j + 1] = true;
				start = j;
				max_pal_length = 2;
			}
		}
		// now for longer length palindromes
		for (int k = 3; k <= n; ++k) {
			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {
				// Get the end index of the substring from start index i and length k
				int j = i + k - 1;

				// check the sub-string from ith index to the jth index if s[i+1] to s[j-1] is a palindrome
				if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					// if current palindrome length is larger than previous largest length, update the maximum length
					if (k > max_pal_length) {
						start = i;
						max_pal_length = k;
					}
				}
			}
		}
		// return longest palindromic substring
		return s.substring(start, start + max_pal_length);
	}
	//T.C: O(N^2), S.C:O(N^2)
	
	//Optimal approach using expand around center 
	
	public static int expand_around_center(String s, int left, int right) {
    	int L = left, R = right;
    	while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
    		L--;
    		R++;
    	}
    	return R - L - 1;
    }
    
    public static String longest_pal(String s) {
    	// if length of string is less than 1 return empty string
    	if (s == null || s.length() < 1) return "";
    	int start = 0, end = 0;
    	for (int i = 0; i < s.length(); i++) {
    		int len1 = expand_around_center(s, i, i);
    		int len2 = expand_around_center(s, i, i + 1);
    		int len = Math.max(len1, len2);
    		if (len > end - start) {
    			start = i - (len - 1) / 2;
    			end = i + len / 2;
    		}
    	}
    	// return longest palindromic substring
    	return s.substring(start, end + 1);
    }
    //T.C: O(N^2), S.C:O(1)
    
    
    public static void main(String[] args){
    	String word = "findnitianhere";
    	System.out.println(longest_palindrome(word));
    	System.out.println("Optimized approach::"+longest_pal(word));
    }

}
