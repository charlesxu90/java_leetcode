/***
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
import java.util.ArrayList;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        Arrays.sort(num);
        int ret = 0;
        int mingap = Integer.MAX_VALUE;
        int i, j, k;
        int sum, gap;
        for (i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                sum = num[i] + num[j] + num[k];
                gap = Math.abs(sum - target);
                if (gap < mingap) {
                    ret = sum;
                    mingap = gap;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ret;
    }
}
