package baekjoon.v1.etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main14502 {
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int[][] result, ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            strings = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(strings[j]);
                ints[i][j] = num;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ints[i][j] == 0) {
                    ints[i][j] = 1;
                    DFS(1);
                    ints[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }

    public static void DFS(int count) {
        if (count == 3) {
            BFS();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ints[i][j] == 0) {
                    ints[i][j] = 1;
                    DFS(count + 1);
                    ints[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = ints[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && result[nx][ny] == 0) {
                    result[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }
}
