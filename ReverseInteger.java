/***
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Be careful of 100, and overflow cases
 */
public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;// replace with 0
        int xabs = Math.abs(x);
        int r = 0;
        while(xabs != 0) {
            if (r  > (Integer.MAX_VALUE - xabs % 10) / 10) // r * 10 might overflow, so change to divide.
                return r > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE; // replace with 0
            r = r * 10 + xabs % 10;
            xabs /= 10;
        }
        return x < 0? -r : r;
    }
}
