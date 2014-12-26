/***
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    
    // Solution 1, S: O(2m+n), T: O(2m+n)
/*
    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) return;

        int [] tmp = new int[m];
        for (int i = 0; i < m; i++)
            tmp[i] = A[i];
        int i = 0, j = 0, k = 0;
        while (i < m + n) {
            if (j < m && (k >= m || tmp[j] <= B[k])) {
                A[i] = tmp[j];
                j++;
            } else {
                A[i] = B[k];
                k++;
            }
            i++;
        }

        for (int itr = 0; itr < tmp.length; itr++)
            System.out.printf("\ttmp itr %d, value %d\n", itr, tmp[itr]);

    }
*/
    
    // Solution 2, S: O(m+n), T:(m+n)
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[k--] = A[i] >= B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }

    public static void main (String args[]) {
        int[] A = new int[4];
        A[0] = 1; A[1] = 3;
        int[] B = {2, 4};
        MergeSortedArray msa= new MergeSortedArray();

        System.out.printf("Original value:\n");

        for (int i = 0; i < A.length; i++)
            System.out.printf("\tA i %d, value %d\n", i, A[i]);

        for (int i = 0; i < B.length; i++)
            System.out.printf("\tB i %d, value %d\n", i, B[i]);

        System.out.printf("Merged value:\n");
        msa.merge(A, 2, B, 2);
        for (int i = 0; i < A.length; i++)
            System.out.printf("\ti %d, value %d\n", i, A[i]);
    }

}
