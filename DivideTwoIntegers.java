/***
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 */
public class Solution {
    // T O(long n), S(1)
    public int divide(int dividend, int divisor) {
        long a = dividend >= 0 ? dividend : - (long) dividend;
        long b = divisor >= 0 ? divisor : - (long) divisor;

        long ret = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; ++i, c <<= 1) {
                a -= c;
                ret += 1 << i;
            }
        }

        if (ret > Integer.MAX_VALUE && (dividend > 0 ^ divisor < 0))
            return Integer.MAX_VALUE;
        return (int)((dividend > 0 ^ divisor > 0) ? (-ret) : ret);
    }
}
