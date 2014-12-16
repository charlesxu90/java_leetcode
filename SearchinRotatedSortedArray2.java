/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 */
public class Solution {
    public int search(int[] A, int target) {
        int low = 0; // index
        int high = A.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[low] != A[high]){
                // binary search
                if (A[low] <= A[mid]){
                    if (target >= A[low] && target < A[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }else{
                    if (target > A[mid] && target <= A[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            } else {// search one by one
                for ( int k = low; k < high; k++){
                    if (A[k] == target)
                        return true;
                }
                return false;
            }
        }
        return -1;
    }

}
