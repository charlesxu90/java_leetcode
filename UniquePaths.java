/***
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */

// 5*4: nchoosem(5, 1) + nchoosem(5, 2) * 2 + nchoosem(5, 3)  
// 3*7: nchoosem(7, 1) + nchoosem(7, 2)

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++)
            map[i][0] = 1;
        for (int j = 0; j < n; j++)
            map[0][j] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }

        return map[m-1][n-1];
    }

    public static void main (String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.format("NO. of paths in 3x7 matrix is: %d.\n", up.uniquePaths(3,7));
    }
}
