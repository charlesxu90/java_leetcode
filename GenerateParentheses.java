/***
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
    // Solution 1: S: O(2^n), T: O(n)
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        StringBuffer s = new StringBuffer("");
        if (n > 0) generate(ret, s, 0, 0, n);
        return ret;
    }
    private void generate(List<String> ret, StringBuffer s, int l, int r, int n) {
        if (n == l) {
            StringBuffer ns = new StringBuffer(s);
            while (n - r > 0) {
                ns.insert(')');
                r++;
            }
            ret.add(ns);
            return;
        }
        s.append('(');
        generate(ret, s, l + 1, r, n);
        s.deleteCharAt(s.length() - 1);
        if (l > r) {
            s.append(')');
            generate(ret, s, l, r + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
    
}
