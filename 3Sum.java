/***
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 *
 *         A solution set is:
 *             (-1, 0, 1)
 *             (-1, -1, 2)
 */
import java.util.ArrayList;

public class Solution {
    // Solution 1. O(n^2) O(1)
    // Sort first,
    // Fixed i, 
    // j starts at i + 1, k starts at n - 1,
    // increase j, decrease k until num[i] + num[j] + num[k] == 0;
    // be careful with duplicated values.

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (n < 3) return ret;
        Arrays.sort(num);
        int target = 0;
        int i, j, k;
        for(i = 0; i < n - 2; i++) {
            j = i + 1;
            if (i > 0 && num[i] == num[i - 1])
                continue;
            k = n - 1;
            while (j < k) {
                if (num[i] + num[j] + num[k] < target) {
                    ++j;
                    while (num[j] == num[j - 1] && j < k) j++;
                } else if (num[i] + num[j] + num[k] > target) {
                    --k;
                    while (num[k] == num[k + 1] && j < k) k--;
                } else {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(num[i]);
                    triplet.add(num[j]);
                    triplet.add(num[k]);
                    ret.add(triplet);
                    ++j;
                    --k;
                    while (num[j] == num[j - 1] && j < k) j++;
                }
            }
        }
        return ret;
    }
}
