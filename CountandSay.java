/***
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
import java.util.StringBuffer;

public class Solution {
    // Solution 1, S: O(n^2), S: O(n)
    public String countAndSay(int n) {
        StringBuffer s = new StringBuffer("1");
        while(--n != 0)
            s = getNext(s);
        return s.toString();
    }

    private StringBuffer getNext(StringBuffer s) {
        StringBuffer sb = new StringBuffer();
        char counter = '1';
        char c = s.charAt(0);
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == c) {
                counter++;
            } else if (i == s.length()){
                sb.append(counter);
                sb.append(c);
            } else {
                sb.append(counter);
                sb.append(c);
                c = s.charAt(i);
                counter = '1';
            }
        }
        return sb;
    }
}
