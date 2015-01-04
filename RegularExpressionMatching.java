/***
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") fasle
 * isMatch("aa","aa") true
 * isMatch("aaa","aa") fasle
 * isMatch("aa", "a*") true
 * isMatch("aa", ".*") true
 * isMatch("ab", ".*") true
 * isMatch("aab", "c*a*b") true
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    // Solution 1: O(n) O(1)
    /*
    private boolean isMatch(String s, int i, String p, int j) {
        int sl = s.length();
        int pl = p.length();
        if (j == pl)  return i == sl;
        if ((j < pl - 1 && p.charAt(i + 1) != '*') || j == pl - 1) {
            return (i < sl && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && isMatch(s, i + 1, p, j + 1);
        }
        while ((i < sl && s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.' && i < sl)) {
            if (isMatch(s, i, p, j + 2))
                return true;
            i++;
        }
        return isMatch(s, i, p, j + 2);
    }
    */

    // Solution 2: O(n), O(1)
    private boolean isMatch(String s, int i, String p, int j) {
        int sl = s.length();
        int pl = p.length();
        if (j == pl)  return i == sl;
        // p(j + 1) is not '*'
        if ((j < pl - 1 && p.charAt(j + 1) != '*') || j == pl - 1) {
            if (i < sl && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) 
                return isMatch(s, i + 1, p, j + 1);
            else 
                return false;
        }
        // If it is,
        while ((i < sl && s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.' && i < sl)) {
            if (isMatch(s, i, p, j + 2))
                return true;
            i++;
        }
        return isMatch(s, i, p, j + 2);
    }

}
