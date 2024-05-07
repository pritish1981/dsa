/**
 * 
 */
package stacks;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring.

 *
 */
public class LongestValidParantheses {

	static int longestValidParantheses(String s) {
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		st.push(-1);
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) == '(')
				st.push(i);
			else {
				st.pop();
				if(st.isEmpty()) {
					st.push(i);
				}else {
					ans = Math.max(ans, i - st.peek());
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(longestValidParantheses(s));

	}

}
