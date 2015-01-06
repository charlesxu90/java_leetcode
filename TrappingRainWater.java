/***
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {
    // Solution 1: O(n)
    /*
    public int trap(int[] A) {
        int n = A.length;
        int max_left[] = new int [n];
        int max_right[] = new int[n];
        // find left max and right max 
        // water stored in a single bar is equal to
        // Min(right_max, left_max) - bar_val
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], A[i - 1]);
            max_right[n - i - 1] = Math.max(max_right[n - i], A[n - i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int height = Math.min(max_left[i], max_right[i]);
            if (height > A[i])
                sum += height - A[i];
        }
        return sum;
    }
    */

    // Solution 2: O(n) O(1)
    // Find max value index
    // Then calculate the right part and left part separately.
    public int trap(int[] A) {
        int imax = 0;
        int n = A.length;
        for (int i = 0; i < n; i++)
            if (A[i] > A[imax]) imax = i;

        int water = 0;
        for ( int i = 0, peak = 0; i < imax; i++)
            if (A[i] > peak) peak = A[i];
            else water += peak - A[i];
        for (int i = n - 1, top = 0; i > imax; i--)
            if (A[i] > top) top = A[i];
            else water += top - A[i];

        return water;
    }
}
