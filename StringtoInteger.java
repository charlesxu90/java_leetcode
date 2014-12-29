/***
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
public class Solution {
    public int atoi(String str) {
        str = str.trim();
        int n = str.length();
        if (n == 0) return 0;
        boolean neg = false;
        int ret = 0;
        int v;
        char c;
        int i = 0;
        c = str.charAt(i);
        if (c == '-'){
            neg = true;
            i++;
        }else if(c == '+') {
            i++;
        }
        for (; i < n; i++) {
            c = str.charAt(i);
            if(c <= '9' && c >= '0'){
                v = c - '0';
                if (ret > (Integer.MAX_VALUE - v) / 10)
                    return neg? Integer.MIN_VALUE : Integer.MAX_VALUE;
                ret = ret * 10 + v;
            } else {
                return neg? -ret : ret;
            }
        }
        return neg? -ret : ret;
    }
}
