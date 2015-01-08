/***
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
    // Solution: O(n), O(1)
    // Move right until all appeared,
    // then, if duplicate appeared, move left.
    public String minWindow(String S, String T) {
        String ret = "";
        int n = S.length();
        int m = T.length();
        if (n == 0 || m == 0)   return ret;
        int[] appeared_count = new int [256];
        int[] expected_count = new int [256];
        for(int i = 0; i < m; i++)
            expected_count[T.charAt(i)]++;
        int start = 0;
        int win_size = Integer.MAX_VALUE;
        int appeared = 0;

        for(int i = 0; i < n; i++) {
            if (expected_count[S.charAt(i)] > 0) {
                appeared_count[S.charAt(i)]++;
                if (appeared_count[S.charAt(i)] <= expected_count[S.charAt(i)])
                    appeared++;
            }

            if (appeared == m) { // contain an T
                while (expected_count[S.charAt(start)] == 0 || appeared_count[S.charAt(start)] > expected_count[S.charAt(start)]) {
                    appeared_count[S.charAt(start)]--;
                    start++;
                }

                if (win_size > (i - start + 1)) {
                    win_size = i - start + 1;
                    ret = S.substring(start, i + 1);
                }
            }
        }
        return ret;
    }
}
