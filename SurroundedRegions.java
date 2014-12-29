/***
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

//import java.util.StringBuffer;

public class Solutions {
    // Solutions 1: intuitive way, search from border to get
    // all available 'O's
    /*
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)){
                    qx.add(i);
                    qy.add(j);
                }
            }
        int x,y;
        while (!qx.isEmpty()) {
            x = qx.remove();
            y = qy.remove();
            board[x][y] = '+';
            if (x > 0 && board[x - 1][y] == 'O'){//Left
                qx.add(x - 1);
                qy.add(y);
            }
            if (x < m - 1 && board[x + 1][y] == 'O'){//Right
                qx.add(x + 1);
                qy.add(y);
            }
            if (y < n - 1 && board[x][y + 1] == 'O'){//Up
                qx.add(x);
                qy.add(y + 1);
            }
            if (y > 0 && board[x][y - 1] == 'O'){//Down
                qx.add(x);
                qy.add(y - 1);
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '+')
                    board[i][j] = 'O';
    }
    */

    // Solutions 2: BFS
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++){
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '+')
                    board[i][j] = 'O';
    }
    private class Pos{
        int x;
        int y;
        public Pos (int x, int y) {
            this.x = x; this.y = y;
        }
    }

    private void bfs (char[][] board, int i, int j) {
        HashSet<Pos> visited = new HashSet<Pos>();
        Queue<Pos> tovisit = new LinkedList<Pos>();
        tovisit.add(new Pos(i, j));
        Pos cur;
        while (!tovisit.isEmpty()) {
            cur = tovisit.poll();
            visited.add(cur);
            int x = cur.x;
            int y = cur.y;
            if (board[x][y] == 'O')
                board[x][y] = '+';
            else 
                continue;
            
            Pos neighbor[] = {new Pos(x - 1, y), new Pos(x + 1, y), new Pos(x, y - 1), new Pos(x, y + 1)};
            for (Pos pos : neighbor) 
                if (!visited.contains(pos) && pos.x >= 0 && pos.y >= 0 && pos.x < board.length && pos.y < board[0].length)
                    tovisit.add(pos);
        }
    }
}
