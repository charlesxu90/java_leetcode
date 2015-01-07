/***
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] ret = new int [n][n];
        if (n == 0) return ret;
        int cur = 1, total = n * n;
        int x= 0, y = 0; 
        while (cur <= total) {
            if (n == 1) {
                ret[x][y] = total;
                break;
            }
            for (int i = 0; i < n - 1; i++)
                ret[x][y++] = cur++;
            for (int j = 0; j < n - 1; j++)
                ret[x++][y] = cur++;
            for (int i = 0; i < n - 1; i++)
                ret[x][y--] = cur++;
            for (int j = 0; j < n - 1; j++)
                ret[x--][y] = cur++;
            x += 1;
            y += 1;
            n -= 2;
        }
        return ret;
    }
}
