/***
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array where num[i] != num[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that num[-1] = num[n] = -Inf.
 *
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 * Note:
 * Your solution should be in logarithmic complexity.
 */

public class Solution {
    // Brute force solution: linear scan, worst case complexity O(n)
    
    // Solution 1: Divide and Conquer O(log n)
    // If  V(mid - 1) < V(mid) && V(mid) > V(mid + 1) return;
    // If V(mid) < V(mid - 1), search in left half,
    // else if V(mid) < V(mid + 1), search in right half.
    public int findPeakElement(int[] num) {
        int n = num.length;
        if (n == 1) return 0;
        int i = 0, j = n - 1, mid;
        while(i < j) {
            mid = (i + j) / 2;
            if ((mid == 0 || num[mid] > num[mid - 1]) && (mid == n - 1 || num[mid] > num[mid + 1]))
                return mid;
            if (mid > 0 && num[mid - 1] > num[mid])
                j = mid - 1;
            else if (mid < n - 1 && num[mid] < num[mid + 1])
                i = mid + 1;
            else {
                int k = mid;
                while(k >= 0 && num[k] == num[mid]) k--;
                if (k == -1 || num[k] > num[mid])
                    j = k;
                else 
                    i = mid + 1;
            }
        }
        return i;
    }
}
