/***
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {
    // Solution 1: O(m * n) O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0)
            return ret;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while(m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++)
                    ret.add(matrix[x][y++];
                break;
            } else if (n == 1) {
                for (int j = 0; j < m; j++)
                    ret.add(matrix[x++][y]);
                break;
            }
            // top - move right
            for (int i = 0; i < n - 1; i++)
                ret.add(matrix[x][y++]);
            // right - move down
            for (int j = 0; j < m - 1; j++)
                ret.add(matrix[x++][y]);
            // bottom - move left
            for (int i = 0; i < n - 1; i++)
                ret.add(matrix[x][y--]);
            // left - move up
            for (int j = 0; j < m - 1; j--)
                ret.add(matrix[x--][y]);
            x++;
            y++;
            m -= 2;
            n-= 2;
        }
        return ret;
    }
    
}
