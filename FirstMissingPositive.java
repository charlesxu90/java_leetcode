/***
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // This is a bucket sort example
        int n = A.length;
        if (n == 0) return 1;
        
        bucketSort(A, n);

        for (int i = 0; i < n; i++)
            if (A[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    private void bucketSort (int[] A, int n) {
        int tmp;
        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] - 1 < n && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                System.out.printf("i %d, A[i] %d\n", i, A[i]);
                tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
                i--;
            }
        }
    }

    public static void main (String args[]) {

        int[] A = new int[]{2, 1};

        FirstMissingPositive fmp = new FirstMissingPositive();

        int ret = fmp.firstMissingPositive(A);
        System.out.printf("First missing positive in {1, 2} is %d\n", ret);

    }
}
