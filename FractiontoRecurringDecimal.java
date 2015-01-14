/***
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * For example,
 *
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)   return "NaN";
        if (numerator == 0) return "0";
        StringBuilder ret = new StringBuilder();
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        // Negative or positive
        if (n * d < 0)  ret.append('-');
        n = Math.abs(n);
        d = Math.abs(d);
        ret.append(Long.toString(n / d));
        // result is integer or float
        if (n % d == 0) return ret.toString();
        else
            ret.append('.');
        // Dealing with float part, store in HashMap
        // Key is the remainder, value is the start position of possible repeating numbers
        // for int, the repeating digits occurs uniquely.
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        Long r = n % d;
        while (r > 0) {
            if (map.containsKey(r)) {
                ret.insert(map.get(r), "(");
                ret.append(')');
                break;
            }
            map.put(r, ret.length());
            r *= 10;
            ret.append(Long.toString(r / d));
            r %= d;
        }
        return ret.toString();
    }
}
