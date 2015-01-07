/***
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
import java.util.List;
import java.util.ArrayList;

public class NQueens {
    // O(n!), O(n)
    public List<String[]> solveNQueens(int n) {
        List<String []> ret = new ArrayList<String []>();
        if (n == 0) return ret;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
            sb.append('.');
        StringBuffer[] solve = new StringBuffer[n];
        for (int i = 0; i < n; i++)
            solve[i] = new StringBuffer(sb.toString());
        boolean[] cols = new boolean[n];
        int[] row = new int[n];
        findSolutions(n, 0, ret, solve, row, cols);
        return ret;
    }

    private void findSolutions(int n, int start, List<String []> ret,
            StringBuffer[] solve, int[] row, boolean[] cols) {
        if (start == n) {
            String[] newsolu = new String[n];
            for (int i = 0; i < n; i++)
                newsolu[i] = solve[i].toString();
            ret.add(newsolu);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i]) continue;
            boolean ok = true;
            for (int j = 0; j < start; j++) {
                // Check if in diagnoal or anti-diagnoal line
                if (Math.abs(start - j) == Math.abs(i - row[j])) {
                    ok = false;
                    break;
                }
            }
            if (ok)  continue;
            cols[i] = true;
            solve[start].setCharAt(i, 'Q');
            row[start] = i;
            findSolutions(n, start + 1, ret, solve, row, cols);
            row[start] = 0;
            solve[start].setCharAt(i, '.');
            cols[i] = false;
        }
    }

    public static void main(String args[]) {
        NQueens nq = new NQueens();
        List<String []> result = new ArrayList<String []>();

        result = nq.solveNQueens(6);
        for (int i = 0; i < result.size(); i++) {
            for (String s: result.get(i)){
                System.out.printf("%s\n", s);
            }
            System.out.println();
        }
    }
}
