/***
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
import java.util.StringBuffer;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) return false;
        char c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c == 'e' || c =='E') {
                return isDouble(s.substring(0, i)) && isDigits(s.substring(i + 1, n), true);
            }
        }
        return isDouble(s);
    }

    private boolean isDouble(String s) {
        int n = s.length();
        if (n == 0) return false;
        int i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+')
            i++;
        if (i == n) return false;
        char c;
        int start = i;
        for (; i < n; i++) {
            c = s.charAt(i);
            if (c == '.') {
                if (i == start && n - i - 1 == 0) // ".", false
                    return false;
                if (n - i - 1 > 0) // "3.", true
                    return isDigits(s.substring(i + 1, n), false);
            } else if (c > '9' || c <'0')
                return false;
        }
        return true;
    }

    private boolean isDigits(String s, boolean sign) {
        int n = s.length();
        if (n == 0) return false;
        int i = 0;
        if (sign == true && (s.charAt(i) == '-' || s.charAt(i) == '+'))
            i++;
        if (i == n) return false; // "4e+", false
        char c;
        for (; i < n; i++) {
            c = s.charAt(i);
            if (c > '9' || c < '0')
                return false;
        }
        return true;
    }
}
