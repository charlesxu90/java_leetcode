/***
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class Solution {
    // Solution 1: DP O(m * n) O(m * n)
    // f[x][y] = min(f[x - 1][y], f[x][y - 1]) + gird[x][y], store path
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int f[][] = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            f[i][0] = f[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++)
            f[0][j] = f[0][j - 1] + grid[0][j];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
        return f[m - 1][n - 1];
    }

    // Solution 2: DP + Array O(m*n) O(n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int f[] = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 0; i < m; i++) {
            f[0] += grid[i][0];
            for (int j = 1; j < n; j++)
                f[j] = min(f[j - 1], f[j]) + grid[i][j];
        }
        return f[n - 1];
    }
}
