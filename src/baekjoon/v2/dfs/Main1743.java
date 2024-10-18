package baekjoon.v2.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1743 {
    static int n, m, count, result;
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int[][] ints, check;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        check = new int[n][m];
        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            ints[x][y] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0 && ints[i][j] == 1) {
                    check[i][j] = 1;
                    count = 0;
                    DFS(i, j);
                    result = Math.max(result, count);
                }
            }
        }
        System.out.println(result);
    }

    public static void DFS(int x, int y) {
        count++;
        for (int i = 0; i < 4; i++) {
            int sx = x + nx[i];
            int sy = y + ny[i];
            if (sx >= 0 && sy >= 0 && sx < n && sy < m && check[sx][sy] == 0 && ints[sx][sy] == 1) {
                check[sx][sy] = 1;
                DFS(sx, sy);
            }
        }
    }
}
