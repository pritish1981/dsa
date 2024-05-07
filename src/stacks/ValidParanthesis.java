/**
 * 
 */
package stacks;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 *
 */
public class ValidParanthesis {

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();// empty stack to store brackets
		for (char c : s.toCharArray()) {
			if (c == '(')
				st.push(')');
			else if (c == '{')
				st.push('}');
			else if (c == '[')
				st.push(']');
			else if (st.isEmpty() || st.pop() != c)
				return false;
		}
		return st.isEmpty();
	}
    //T.C:O(n), S.C: O(n)
	
	public static void main(String[] args) {
		String s = "()[]{}";
		isValid(s);
		System.out.println("Valid paranthesis possible ? :: "+ isValid(s));

	}

}
