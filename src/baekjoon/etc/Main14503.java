package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ints;
    static int n, m;
    static int result = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        String[] strings1 = bufferedReader.readLine().split(" ");
        int startX = Integer.parseInt(strings1[0]);
        int startY = Integer.parseInt(strings1[1]);
        int status = Integer.parseInt(strings1[2]);
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] strings2 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(strings2[j]);
            }
        }
        DFS(startX, startY, status);
        System.out.println(result);
    }

    public static void DFS(int x, int y, int st) {
        // 0 북 1 동 2 남 3 서
        ints[x][y] = 2;
        // 왼쪽 방향 처리 완료
        for (int i = 0; i < 4; i++) {
            // 북같은경우 1빼면 -1이기 때문에 3(서)로 넣어준다
            st -= 1;
            if (st == -1) {
                st = 3;
            }
            int nx = x + dx[st];
            int ny = y + dy[st];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (ints[nx][ny] == 0) {
                    result++;
                    DFS(nx, ny, st);
                    return;
                }
            }
        }
        // 모든 방향이 없을경우
        int back = (st + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if (bx >= 0 && by >= 0 && bx < n && by < m && ints[bx][by] != 1) {
            DFS(bx, by, st);
        }

    }
}
