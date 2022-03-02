package inflearn.dfsbfsUpgrade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main13 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(strings1[j]);
                if (ints[i][j] == 2) {
                    DFS(i, j);
                }
            }
        }
    }

    public static void DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return;
        }
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
        }

    }
}
