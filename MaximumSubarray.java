/***
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 * click to show more practice.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Solution {
    // Solution 1: 1 d DP: O(n) O(1)
    /*
    public int maxSubArray(int[] A) {
        int local_max = A[0];
        int global_max = A[0];

        for (int i = 1; i < A.length; i++) {
            local_max = local_max + A[i] > A[i] ? local_max + A[i] : A[i];
            global_max = local_max > global_max ? local_max : global_max;
        }
        return global_max;
    }
    */

    // Solution 2: divide and conquer, O(log n)
    public int maxSubArray(int[] A) {
        int maxV = Integer.MIN_VALUE;
        return maxSubArray(A, 0, A.length - 1, maxV);
    }
    private int maxSubArray(int A[], int left, int right, int maxV) {
        if (left > right)
            return Integer.MIN_VALUE;
        int mid = (left + right) / 2;
        int lmax = maxSubArray(A, left, mid - 1, maxV);
        int rmax = maxSubArray(A, mid + 1, right, maxV);
        maxV = Math.max(maxV, lmax);
        maxV = Math.max(maxV, rmax);
        int local = 0, lm = 0;
        for (int i = mid - 1; i >= left; i--){
            local = local + A[i];
            lm = Math.max(local, lm);
        }
        local = 0; 
        int rm = 0;
        for (int i = mid + 1; i <= right; i++) {
            local = local + A[i];
            rm = Math.max(local, rm);
        }
        maxV = Math.max(maxV, lm + rm + A[mid]);
        return maxV;

    }
}
