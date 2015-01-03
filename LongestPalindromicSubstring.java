/***
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    // Solution 1: T/S,O(n^2)
    /*
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = "";
        String str = "";
        for (int i = 0; i < n; i++) {
            str = getPalindrome(s, i, i);
            if (str.length() > result.length())
                result = str;
            str = getPalindrome(s, i, i + 1);
            if (str.length() > result.length())
                result = str;
        }
        return result;
    }

    private String getPalindrome(String str, int l, int r) {
        while(l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }
    */

    // Solution 2: Dynamic programming. T/S O(n^2)
    public String longestPalindrome( String s) {
        int n = s.length();
        boolean f[][] = new boolean[n][n];
        Arrays.fill();
        int max_len = 1, start = 0;
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
            for (int j = 0; j < i; j++) {
                f[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1]));
                if (f[j][i] && max_len < (i - j + 1)) {
                    max_len = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max_len);
    }
    // Solution 3. Manacher's algorithm : T/S O(n) 
    // Very complicated, haven't implemented yet.
    /*
    public String longestPalindrome(String s) {

    }
    */
}
