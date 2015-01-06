/***
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 */
import java.util.ArrayList;
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> ret = new ArrayList<String>();
        if (strs.length == 1) return ret;
        ArrayList<String> alst = new ArrayList<String>();
        for (String s: strs) {
            char [] car = s.toCharArray();
            Arrays.sort(car);
            alst.add(new String(car));
        }

        int[] list = new int[strs.length]; // records whether this is an anagrams.
        int tmp = 0;
        for (int i = 0; i < alst.size(); i++) {
            if (list[i] != 0)
                continue;
            list[i] = 1;
            tmp = 1;
            for (int j = i + 1; j < alst.size(); j++) {
                if (list[j] == 0 && alst.get(i).equals(alst.get(j))) {
                    list[j] = 1;
                    tmp++;
                }
            }
            if (tmp == 1)
                list[i] = 0;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] == 1)
                ret.add(strs[i]);
        }

        return ret;
    }
}
