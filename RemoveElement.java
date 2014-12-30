/***
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    /*
    public int removeElement(int[] A, int elem) {
        if (A.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem)
                j++;
            else
                A[i - j] = A[i];
        }
        return A.length - j;
    }
    */
    public int removeElement(int[] A, int elem) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[index++] = A[i];
        }
        return index;
    }
}
