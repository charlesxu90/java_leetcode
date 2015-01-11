/***
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0')
            return 0;

        int prev = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '0') 
                // If prev == '0', only one situation, cur = 0
                cur = 0;
            if (i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6' && s.charAt(i - 1) >= '0')))
                // If prev2 == '1' or prev2 == '2' &&  '0' <= prev1 <= '6', there might be multiple situations, but otherwise, only one situation
                prev = 0;
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        return cur;
    }
}
