package programmers.kakao;

public class Solution7 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        DFS(aloc[0], aloc[1], bloc[0], bloc[1], "a", board, 0);
        return answer;
    }

    public static void DFS(int ax, int ay, int bx, int by, String check, int[][] board, int score) {
        // 둘중 하나라도 움직일 수 없다면
        if (!moveCheck(ax, ay, board) || !moveCheck(bx, by, board)) {

            return;
        }
        // 둘의 자리가 같아서 다음번에 이동하면 끝남
        if (ax == bx && ay == by) {
            return;
        }


        int nx, ny;
        int x, y;
        if (check.equals("a")) {
            x = ax;
            y = ay;
        } else {
            x = bx;
            y = by;
        }
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            board[x][y] = 0;
            score++;
            DFS(nx, ny, bx, by, "b", board, score);
            board[x][y] = 1;
            score--;
        }


    }

    public static boolean moveCheck(int x, int y, int[][] board) {
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 1) {
            return true;
        }
        return false;
    }
}