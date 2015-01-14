/***
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {
    // Solution 1: DFS O(2^n) O(n)
    //
    public boolean wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, 0, 0);
    }

    private boolean dfs(String s, Set<String> dict, int start, int cur) {
        if (cur == s.length()) {
            return dict.contains(s.substring(start, s.length()));
        }

        if (dfs(s, dict, start, cur + 1)) return true;
        if (dict.contains(s.substring(start, cur + 1)))
            if (dfs(s, dict, cur + 1, cur + 1))  return true;
        return false;
    }

    // Solution 2: DP O(n^2) O(n)
    // f[i] = f[j1] && check(i, j1) || f[j2] && check(i, j2) || ...
    // (0 <= j < i)
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean f[] = new boolean [n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
