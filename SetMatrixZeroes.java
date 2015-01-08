/***
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * click to show follow up.
 *
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Solution {
    // Solution 1: O(m * n), O(m + n);
    /*
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        int row[] = new int [m];
        int col[] = new int [n];
        Arrays.fill(row, 1);
        Arrays.fill(col, 1);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (row[i] == 0 || col[j] == 0)
                    matrix[i][j] = 0;
        
    }
    */

    // Solution 2: O(m * n), O(1)
    public void setZeroes( int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        boolean zero_in_first_col = false;
        boolean zero_in_first_row = false;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0)
                zero_in_first_col = true;
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0)
                zero_in_first_row = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (zero_in_first_col) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }

        if (zero_in_first_row)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }
}
