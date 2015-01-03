/***
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

import java.util.StringBuffer;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer ret = new StringBuffer();
        int an = a.length();
        int bn = b.length();
        int n = an > bn? an : bn;
        int addup = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (an - i >= 0 && bn - i >= 0) {
                sum = a.charAt(an - i) - '0' + b.charAt(bn - i) -'0' + addup;
            } else if (an - i < 0) {
                sum = b.charAt(bn - i) - '0'+ addup;

            } else if (bn - i < 0) {
                sum = a.charAt(an - i) - '0' + addup;
            }
            ret.append(sum % 2 == 0 ? '0' : '1');
            addup = sum / 2 == 1? 1 : 0;
        }
        if (addup == 1)
            ret.append('1');
        return ret.reverse().toString();
    }
}
