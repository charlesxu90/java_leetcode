/***
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        // binary search
        if (A.length == 0) return 0;
        return findLow(A, target, 0, A.length - 1);
    }

    private int findLow(int[] A, int target, int l, int r) {
        int mid;
        while (l < r) {// Find low, so here it is <
            mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return A[l] < target? l + 1 : l;
    }
}
