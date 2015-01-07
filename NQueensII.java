/***
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */

import java.util.ArrayList;

public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
            sb.append('.');
        StringBuffer[] solve = new StringBuffer[n];
        for (int i = 0; i < n; i++)
            solve[i] = new StringBuffer(sb.toString());
        boolean[] cols = new boolean[n];
        int[] row = new int[n];
        int [] ret = new int[1];
        findSolutions(n, 0, ret, solve, row, cols);
        return ret[0];
    }

    private void findSolutions(int n, int start, int[] ret,
            StringBuffer[] solve, int[] row, boolean[] cols) {
        if (start == n) {
            ret[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i]) continue;
            boolean ok = true;
            for (int j = 0; j < start; j++) {
                if (Math.abs(start - j) == Math.abs(i - row[j])) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                cols[i] = true;
                solve[start].setCharAt(i, 'Q');
                row[start] = i;
                findSolutions(n, start + 1, ret, solve, row, cols);
                row[start] = 0;
                solve[start].setCharAt(i, '.');
                cols[i] = false;
            }
        }
    }
}
