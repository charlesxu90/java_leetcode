/***
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    // Solution 1: O(n), O(1)
    // [left, right] contains currently reachable,but not 
    // visited indexes.
    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        int left = 0;
        int right = 0;
        int step = 0;
        while (left <= right) {
            step++;
            int old_right = right;
            for (int i = left; i <= old_right; ++i) {
                right = i + A[i] > right ? i + A[i]: right;
                if (right >= A.length - 1)
                    return step;
            }
            left = old_right + 1;
        }
        return 0;
    }
}
