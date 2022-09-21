package programmers.kakao;

public class Solution7 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        DFS(aloc[0], aloc[1], bloc[0], bloc[1], "a", board);
        return answer;
    }

    public static void DFS(int ax, int ay, int bx, int by, String check, int[][] board) {
        if (!moveCheck(ax, ay, board)) {
            return;
        }
        if (!moveCheck(bx, by, board)) {
            return;
        }


    }

    public static boolean moveCheck(int x, int y, int[][] check) {
        if (x >= 0 && y >= 0 && x < check.length && y < check[0].length && check[x][y] == 1) {
            return true;
        }
        return false;
    }
}