/***
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution {
    // Solution 1: O(n)
    /*
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<Integer>();
        int max_len = 0, last = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);    // store positions of '('
                continue;
            }

            if (stk.isEmpty()) {
                last = i;
                continue;
            }

            stk.pop();
            if (stk.isEmpty())
                max_len = Math.max(max_len, i - last);
            else
                max_len = Math.max(max_len, i - stk.peek());
        }
        return max_len;
    }
    */

    // Solution 2. Dynamic Programming O(n)
    public int longestValidParentheses(String s) {
        int n = s.length();
        int f[] = new int [n];
        int ret = 0;
        for (int i = n - 2; i >= 0; --i) {
            int match = i + f[i + 1] + 1;
            // case "(( ... ))"
            if (s.charAt(i) == '(' && match < n && s.charAt(match) == ')') {
                f[i] = f[i + 1] + 2;
                // case "((...))()"
                if (match + 1 < n) f[i] +=f[match + 1];
            }
            ret = Math.max(ret, f[i]);
        }
        return ret;
    }
}
