/***
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 *   ]
 * Given target = 3, return true.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        if (matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;
        int mid, value;
        while (l <= r) {
            mid = (r + l) / 2;
            System.out.printf("l %d, r %d, mid %d\n", l, r, mid);
            if (mid >= m * n)
                break;
            value = matrix[mid / n][mid % n];

            if (value == target)
                return true;
            else if (value < target)
                l = mid + 1;
            else 
                r = mid - 1;
        }
        return false;
    }

    public static void main (String args[]) {
        int[][] matrix1 = new int[2][2];
        matrix1[0] = new int[] {1, 2};
        matrix1[1] = new int[] {3, 4};
        int[][] matrix2 = new int[1][1];
        matrix2[0][0] = 1;
        int query1 = 3;
        int query2 = 0;

        Searcha2DMatrix s2dmtx = new Searcha2DMatrix();

        System.out.printf("Query result: %b\n",s2dmtx.searchMatrix(matrix1, query1));
        System.out.printf("Query result: %b\n",s2dmtx.searchMatrix(matrix2, query2));


    }
}
