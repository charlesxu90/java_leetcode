/***
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Solution {
    // Solution O(n^2 * m^2) S: O(n^2
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, word, 0))
                    return true;
            }
        return false;
    }

    private boolean dfs(char [][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(index))  return false;

        visited[i][j] = true;
        boolean ret = dfs(board, visited, i - 1, j, word, index + 1) || // up
            dfs(board, visited, i + 1, j, word, index + 1) || // down
            dfs(board, visited, i, j - 1, word, index + 1) || // left
            dfs(board, visited, i, j + 1, word, index + 1); // right
        visited[i][j] = false;
        return ret;
    }
}
