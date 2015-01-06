/***
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    // O(n * m) O(m)
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        if (L.length == 0 || L.length * L[0].length() > S.length()) return ret;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : L)
            map.put(s, map.containsKey(s) ? map.get(s).intValue() + 1 : 1);
        
        int index = 0;
        for (int start = 0, end = L.length * L[0].length() - 1;
                end < S.length(); start++, end++) {
            index = check(S, start, end, L.length, L[0].length(),
                    L, map);
            if (index > -1) ret.add(index);
        }
        return ret;
    }

    private int check (String s, int start, int end, int m, int n, String[] L, HashMap<String, Integer> map) {
        HashMap<String, Integer> used = new HashMap<String, Integer>();
        int idx = start;
        while (idx <= end) {
            String str = s.substring(idx, idx + n);
            if (map.containsKey(str)) {
                if (used.containsKey(str)) {
                    int i = used.get(str);
                    if (i == map.get(str))
                        return -1;
                    else
                        used.put(str, i + 1);
                } else
                    used.put(str, 1);
                idx += n;
            } else
                return -1;
        }
        return start;
    }
}
