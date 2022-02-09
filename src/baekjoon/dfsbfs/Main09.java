package baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main09 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ints, ch, result;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[n][m];
        result = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split("");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(strings1[j]);
                ints[i][j] = num;
                if (num == 1) {
                    ch[i][j] = 1;
                }
            }
        }
        BFS();
    }

    public static void BFS() {
        int nx, ny;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        ch[0][0] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (ints[nx][ny] == 0 && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

    }
}
