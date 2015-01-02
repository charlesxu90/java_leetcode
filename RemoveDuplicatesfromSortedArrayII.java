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
    // Solution 1: T O(n), S O(1)
    /*
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
    */
    // Solution 2:  T O(n), S O(1)
    public int removeDuplicates(int[] A) {
        // Good scalability, change 2 to 3, then can handle at most three times
        if (A.length <= 2)
            return A.length;
        int index = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[index - 2])
                A[index++] = A[i];
        }
        return index;
    }
    
    // Solution 3: T O(n), S O(1)
    /*
    public int removeDuplicates(int[] A) {
        int index = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1 && A[i] == A[i - 1] && A[i] == A[i + 1])
                continue;
            A[index++] = A[i];
        }
        return index;
    }
    */

}
