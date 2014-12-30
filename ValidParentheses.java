/***
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        String left = "([{";
        String right = ")]}";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.indexOf(c) != -1 ) {
                stk.push(c);
            } else {
                if (stk.empty() || stk.pop() != left.charAt(right.indexOf(c)))
                    return false;
            }
        }
        return stk.empty();
    }
}
