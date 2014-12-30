/***
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array A = [1,1,2],
 *
 * Your function should return length = 2, and A is now [1,2].
 */
public class Solution {
    // Solution 1:
    /*
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int j = 1;
        for (int i = 1; i < A.length; i++)
            if (A[i - j] == A[i])
                j++;
            else
                A[i - j + 1] = A[i];
        return A.length - j + 1;
    }
    */
    // Solution 2:
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int index = 0;
        for (int i = 1; i < A.length; i++)
            if (A[index] != A[i])
                A[++index] = A[i];
        return index + 1;
    }

}
