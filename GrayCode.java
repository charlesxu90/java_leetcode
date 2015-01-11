/***
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 *
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {
    // Solution 1: O(2^n,) O(1)
    /*
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>(); 
        ret.add(0);
        if (n == 0) return ret;
        int size = 1 << n;
        // generates a series of binary natural code, then convert to gray code
        for (int i = 1; i < size; i++)
            ret.add(binaryToGray(i));
        return ret;
    }

    private int binaryToGray(int n) {
        return n ^ (n >> 1);
    }
    */

    // Solution 2: O(2^n) O(1)
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>(); 
        ret.add(0);
        if (n == 0) return ret;
        for (int i = 0; i < n; i++) {
            int highest_bit = 1 << i;
            for (int j = ret.size() - 1; j >= 0; j--) {
                ret.add(highest_bit | ret.get(j));
            }
        }
        return ret;
    }
    // n = 2, ret = {0, 1, 3, 2}
}
