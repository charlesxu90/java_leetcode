/***
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 */
public class Solution {
    // Solution 1: O(n), O(1)
    public boolean canJump(int[] A) {
        int reach = A[0];
        for (int i = 1; i < A.length && reach < A.length - 1; ++i)
            if (reach >= i)
                reach = Math.max(reach, i + A[i]);
        return reach >= A.length - 1;
    }
}
