/***
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 */
public class Solution {
    // Solution 1. O(log n) O(1)
    //  Search for index which arr[i] > arr[i + 1]
    public int findMin(int[] num) {
        if (num.length == 1)
            return num[0];
        return findMin(num, 0, num.length - 1);
    }
    private int findMin(int[] num, int lid, int hid) {
        if (lid >= hid) 
            return num[lid];
        int mid = (lid + hid) / 2;
        if (num[mid] > num[mid + 1])
            return num[mid + 1];
        if (num[mid] > num[hid])
            return findMin(num, mid, hid);
        else if (num[mid] < num[hid])
            return findMin(num, lid, mid);
        else {
            if (num[lid] == num[hid])
            return findMin(num, lid + 1, hid -1);
            else
                return findMin(num, lid, hid - 1);
        }
    }
    // Solution 2. O(log n) O(1)
    //  split the sorted, rotated array into two halves,
    //  one is sorted and the other is not, 
    //  min is always in the unsorted one
    public int findMin(int[] num) {
        int l = 0;
        int h = num.length - 1;
        int mid;
        while (l < h) {
            if (num[l] < num[h])
                return num[l];
            mid = (l + h) / 2;
            if (num[mid] > num[h])
                l = mid + 1;
            else if (num[mid] < num[h]) 
                h = mid;
            else {
                if (num[l] == num[h]) {
                    l++;
                    h--;
                } else
                    l++;
            }
        }
        return num[l];
    }
}
