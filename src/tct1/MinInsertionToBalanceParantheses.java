package tct1;

/*
Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.



Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
Example 2:

Input: s = "())"
Output: 0
Explanation: The string is already balanced.
Example 3:

Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.


Constraints:

1 <= s.length <= 10^5
s consists of '(' and ')' only.

 */
public class MinInsertionToBalanceParantheses {
    public static int minInsertions(String s) {
        int right = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (right % 2 > 0) {
                    right--;
                    ans++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    ans++;
                }
            }
        }
        return ans + right;
    }
    //Time Complexity: O(n), Space Complexity: O(1)

    public static void main(String[] args) {
        String s = "))())(" ;
        System.out.println("Minimum insertion to balance the parentheses in the string is :: "+minInsertions(s));
    }

}
