/***
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 */

public class Solution {
    // (2, 5) combine occurs cause one trailing zero,
    // as 2 is very common, only 5 counts
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int c5 = 0;
        int size;
        while (n > 0) {
            size = n/5;
            c5 += size;
            n /= 5;
        }
        return c5;

    }
}
