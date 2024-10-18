package baekjoon.v2.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4963 {
    static int[] nx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] ny = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[][] ints, check;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            if (n == 0 && m == 0) break;
            ints = new int[m][n];
            check = new int[m][n];
            for (int i = 0; i < m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j] == 0 && ints[i][j] == 1) {
                        DFS(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void DFS(int x, int y) {
        check[x][y] = 1;
        for (int i = 0; i < 8; i++) {
            int sx = x + nx[i];
            int sy = y + ny[i];
            if (sy >= 0 && sx >= 0 && sx < m && sy < n && ints[sx][sy] == 1 && check[sx][sy] == 0) {
                DFS(x + nx[i], y + ny[i]);
            }
        }
    }
}
