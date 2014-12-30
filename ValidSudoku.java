/***
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean used[] = new boolean[9];

        for (int i = 0; i < 9; i++){

            // check line
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++)
                if (!check(board[i][j], used))
                    return false;
            // check column
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++)
                if (!check(board[j][i], used))
                    return false;
        }
        //check 3x3 matrix
        for (int l = 0; l < 3; l++)
            for (int c = 0; c < 3; c++) {
                Arrays.fill(used, false);
                for (int i = l * 3; i < (l + 1) * 3; i++)
                    for (int j = c * 3; j < (c + 1) * 3; j++)
                        if (!check(board[i][j], used))
                            return false;
            }
        return true;
    }

    boolean check (char c, boolean used[]) {
        if (ch == '.') return true;
        if (used[c - '1']) return false;
        return used[c - '1'] = true;
    }
}
