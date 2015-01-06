/***
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 */
public class Solution {
    // Two methods:
    // 1. Swap vals in symmetry along middle horizontal line, then Swap vals in symmetry along secondary diagonal line;
    // 2. Swap vals in symmetry along diagonal line, the swap vals in symmetry along middle horizontal line.
    // Either is OK.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        int temp;
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }
}
