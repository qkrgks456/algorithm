package programmers.kakao.test2022;

public class Solution7 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return DFS(aloc[0], aloc[1], bloc[0], bloc[1], board, 0).count;
    }

    public static Result DFS(int x, int y, int cx, int cy, int[][] board, int score) {
        boolean win = false;
        int minCount = 5 * 5;
        int maxCount = score;
        int nx, ny;
        if (board[x][y] == 1) {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (moveCheck(nx, ny, board)) {
                    board[x][y] = 0;
                    Result r = DFS(cx, cy, nx, ny, board, score + 1);
                    win |= !r.win;
                    if (!r.win) {
                        minCount = Math.min(minCount, r.count);
                    } else {
                        maxCount = Math.max(maxCount, r.count);
                    }
                    board[x][y] = 1;
                }
            }
        }
        return new Result(win, win ? minCount : maxCount);
    }

    public static boolean moveCheck(int x, int y, int[][] board) {
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 1) {
            return true;
        }
        return false;
    }
}

class Result {
    boolean win;
    int count;

    public Result(boolean win, int count) {
        this.win = win;
        this.count = count;
    }
}