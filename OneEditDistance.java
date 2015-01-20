/***
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
/**
 * Notes: 
 *
 *   If you try to use the Dynamic Program Algorithm, just like the `Edit Distance`, 
 *   Then, you will get `Memory Limit Error` or `Time Limit Error`.
 *
 *   The Dynamic Program Algorithm which `Edit Distance` prolem used call `Wagner–Fischer Algorithm`
 *   (refer to: http://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm)
 *   Ths DP algorithm's  time complexity is O(m*n), and the space complexity is O(m*n) as well, 
 *   You can optimized the space complexity to O(2*min(m,n)), but it still have `Time Limit Error`
 *
 *   Fortunately, this problem just for the `One` edit distance, so, this is special case we can solve it by special way.
*/
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        int n = Math.min(s.length(), t.length());
        boolean onediff = false;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            if (s.charAt(i) == s.charAt(j))
                continue;
            if (onediff)
                return false;
            onediff = true;
            if (s.length() > n)
                i--;
            else if (t.length() > n)
                j--;
        }
        return onediff || (!onediff && (Math.abs(s.length() - t.length()) == 1));
    }
}

