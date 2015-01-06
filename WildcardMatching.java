/***
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    // Solution 1: Recursive: O(n!*m!) O(n)
    ///*
    public boolean isMatch(String s, String p) {
        System.out.printf("s %s, p %s\n", s, p);
        if (p.length() > 0 && p.charAt(0) == '*') {
            int i = 1;
            while(i < p.length() && p.charAt(i) == '*') i++;
            if (i == p.length()) return true;
            int j = 0;
            while(j < s.length() && !isMatch(s.substring(j, s.length()), p.substring(i, p.length()))) j++;
            return j != s.length();
        }
        else if (p.length() == 0 || s.length() == 0) {
            return p.length() == s.length();
        } else if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') {
            return isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
        } else 
            return false;
    }
    //*/

    // Solution 2: Iterative O(n*m) O(1)
    /*
    public boolean isMatch(String s, String p) {
        int star = -1;
        int i = 0, j = 0, match = -1;
        int sl = s.length(), pl = p.length();
        while (i < sl) {
            System.out.printf("i %d, j %d\n", i, j);
            if (j < pl && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
                System.out.printf("star %d, match %d\n", star, match);
                i++;
                j++;
            }else if (j < pl && p.charAt(j) == '*') {
                match = i;
                star = j;
                j++;
                System.out.printf("star %d, match %d\n", star, match);
            }else if (star != -1) {
                j = star + 1;
                match = match + 1;
                i = match;
                System.out.printf("star %d, match %d\n", star, match);
            }else 
                return false;
        }
        System.out.printf("i %d, j %d", i, j);
        while (j < pl && p.charAt(j) == '*') j++;
        return j == pl;
    }
    */

    public static void main (String args[]) {
        WildcardMatching wm = new WildcardMatching();
        System.out.printf("aa and * run wm is %b\n", wm.isMatch("aa", "*"));
         System.out.printf("aa and ab run wm is %b\n", wm.isMatch("aa", "ab"));
   }
}
