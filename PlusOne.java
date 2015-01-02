/***
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int addup = 1;

        for (int i = n - 1; i >= 0; i--){
            if (digits[i] + addup >= 10) {
                digits[i] += addup - 10;
            } else {
                digits[i] += addup;
                addup = 0;
            }
            if (addup == 0)
                return digits;
        }

        int newdigits[] = new int[n + 1];
        newdigits[0] = 1;
        for (int i = 2; i <= n; i++)
            newdigits[i] = digits[i - 1];
        return newdigits;

    }
}

