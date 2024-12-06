package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] result = new int[3];
    static int[][] ints, check;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            check = new int[n][m];
            for (int j = 0; j < m; j++) {
                check[i][j] = 1;
                DFS(i, j, 1, ints[i][j]);
                DFS2(i, j, 0, 0);
            }
        }
        System.out.println(max);
    }

    // ㅗ <- 얘만 해결되면 될것 같은데 ㅋㅋ
    public static void DFS(int x, int y, int level, int sum) {
        if (level == 4) {
            max = Math.max(max, sum);
            return;
        }
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && check[nx][ny] == 0) {
                check[nx][ny] = 1;
                DFS(nx, ny, level + 1, sum + ints[nx][ny]);
                check[nx][ny] = 0;
            }
        }
    }

    // 여기는 아마 조합 때처럼 4개중에서 3개 뽑는걸로 가야할듯
    public static void DFS2(int x, int y, int level, int index) {
        if (level == 3) {
            int nx, ny;
            int sum = ints[x][y];
            for (int num : result) {
                nx = x + dx[num];
                ny = y + dy[num];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    sum += ints[nx][ny];
                } else {
                    break;
                }
            }
            max = Math.max(sum, max);
            return;
        }
        for (int i = index; i < 4; i++) {
            result[level] = i;
            DFS2(x, y, level + 1, i + 1);
        }
    }
}
