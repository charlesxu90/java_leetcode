/***
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Solution {
    // T/S: O(log(m+n)
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length + B.length;
        if (m % 2 != 0)
            return findKth(A, 0, B, 0, m / 2 + 1);
        else
            return (findKth(A, 0, B, 0, m / 2) + findKth(A, 0, B, 0, m / 2 + 1)) / 2.0;
    }

    private double findKth (int A[], int as, int B[], int bs, int k) {
        if(A.length - as > B.length - bs)
            return findKth(B, bs, A, as, k);
        if ( as >= A.length)
            return (double) B[bs + k - 1];
        if (k == 1)
            return (double) Math.min(A[as], B[bs]);
        
        int ia = Math.min(k / 2, A.length - as);
        int ib = k - ia;
        if (A[as + ia - 1] < B[bs + ib - 1])
            return findKth(A, as + ia, B, bs, k - ia);
        else if (A[as + ia - 1] > B[bs + ib - 1])
            return findKth(A, as, B, bs + ib, k - ib);
        else
            return A[as + ia - 1];
    }
}
