/***
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int index = 0;
        int counter = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[index]) {
                index++;
                A[index] = A[i];
                counter = 1;
            } else if (counter == 1) {
                index++;
                A[index] = A[i];
                counter++;
            } else 
                counter = 0;
        }
        return index + 1;
    }
}
