package baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main06 {
    static int m, n;
    static int[][] ints, ch;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        m = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        ints = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split(" ");
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(strings1[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ints[i][j] == 1 && ch[i][j] == 0) {
                    BFS(i, j);
                }
            }
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        ch[x][y] = 1;
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                }
            }
        }
    }
}
