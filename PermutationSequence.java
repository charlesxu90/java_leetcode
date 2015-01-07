/***
 * The set [1,2, 3 ... ,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.Arrays;
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int A[] = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = i + 1;
        while(--k != 0)
            getNext(A);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
            sb.append(A[i]);
        return sb.toString();
    }
    private void getNext(int [] A) {
        int i;
        for (i = A.length - 1; i > 0; i--)
            if (A[i] > A[i - 1]) break;
        int k = i - 1;
        for (; i < A.length; i++) {
            if (A[i] <= A[k]) break;
        }
        int p = i - 1;
        int temp = A[k];
        A[k] = A[p];
        A[p] = temp;
        // sort right of k
        Arrays.sort(A, k + 1, A.length);
    }

    public static void main (String args[] ) {
        PermutationSequence ps = new PermutationSequence();
        String s = ps.getPermutation(3, 5);
        System.out.printf("S for n = 3, k = 5 is : %s \n", s);
    }
}
