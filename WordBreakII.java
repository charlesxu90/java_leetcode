/***
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class WordBreakII {
    // Solution DP + DFS O(n^2) O(n^2)
    public List<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean f[] = new boolean [n + 1];
        boolean prev[][] = new boolean[n + 1][n];
        f[0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = i - 1; j >= 0; j--)
                if (f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    prev[i][j] = true;
                }
        for (boolean b: f)
            System.out.printf("%b\n", b);
        List<String> ret = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        genPath(s, ret, prev, path, n);
        return ret;
    }

    private void genPath(String s, List<String> ret, boolean[][] prev, List<String> path, int cur) {
        if (cur == 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = path.size() - 1; i >= 0; i--)
                sb.append(path.get(i) + " ");
            sb.setLength(sb.length() - 1);
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (prev[cur][i]) {
                path.add(s.substring(i, cur));
                genPath(s, ret, prev, path, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        WordBreakII wb2 = new WordBreakII();
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        List<String> result = wb2.wordBreak("abc", dict);
        for (String s: result)
            System.out.printf("%s\n", s);
    }
}
