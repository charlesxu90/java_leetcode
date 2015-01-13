/***
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {

    // Simulate 3 Hex computation. O(n) O(1)
    public int singleNumber(int[] A) {
        int W = 32;
        int count[] = new int[W];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < W; j++) {
                count[j] += (A[i] >> j) & 1;
                count[j] %= 3;
            }
        }

        int result = 0;
        for (int i = 0; i < W; i++)
            result += (count[i] << i);
        return result;
    }

    // Solution 2:
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++){
            twos |= (ones & A[i]);
            ones ^= A[i];
            threes = ~(ones & twos);
            ones &= threes;
            twos &= threes;
        }
        return ones;

    }

}
