/***
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Solution {
    // Brute force idea O(m(m-1)/2 * n (n-1)/2)
    
    // Solution 1: O(n^3)
    /*
    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        int numRows = matrix.length;
        if (numRows == 0)   return 0;
        int numCols = matrix[0].length;
        int rowArea[][] = new int [numRows][numCols];
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++) {
                // calculate max area bottom left start at (i, j)
                if (matrix[i][j] == '0') continue;
                // update height matrix
                if (j == 0) rowArea[i][j] = 1;
                else 
                    rowArea[i][j] = rowArea[i][j - 1] + 1;
                int y = 1;
                int x = numCols;
                while (i - y + 1 >= 0 && rowArea[i - y + 1][j] > 0) {
                    x = Math.min(x, rowArea[i - y + 1][j]);
                    area = Math.max(area, x*y);
                    y++;
                }
                //
            }
        return area;
    }
    */
    
    // Solution 2: O(n^2), O(n)
    // Idea: Maintain a Left, Right, and Height array during area
    // calculation. 
    // For each Row:
    //  First update Left and Height array, If meet '0', turn left to 0, right to n, and height to n, and increase left.
    //  Then update Right array and Area. If meet '0', set right to j.
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int H[] = new int[n];
        int L[] = new int[n];
        int R[] = new int[n];
        // L, R are both used for scanning and calculation purpose.
        Arrays.fill(R, n);

        int ret = 0;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    ++H[j];
                    L[j] = Math.max(L[j], left);
                } else {
                    left = j + 1;
                    H[j] = 0; L[j] = 0; R[j] = n;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(R[j], right);
                    ret = Math.max(ret, H[j] * (R[j] - L[j]));
                } else {
                    right = j;
                }
            }
        }
        return ret;
    }
}
