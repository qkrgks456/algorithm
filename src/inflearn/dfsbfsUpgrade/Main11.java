package inflearn.dfsbfsUpgrade;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main11 {
    static Queue<Point> queue = new LinkedList<>();
    static int[][] ints, ch, result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        m = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        ints = new int[n][m];
        ch = new int[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(strings1[j]);
                if (ints[i][j] == 1) {
                    queue.add(new Point(i, j));
                    ch[i][j] = 1;
                } else if (ints[i][j] == -1) {
                    ch[i][j] = 1;
                }
            }
        }
        BFS();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                if (max < result[i][j]) {
                    max = result[i][j];
                }
            }
        }
        System.out.println(max);
    }

    public static void BFS() {
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    result[nx][ny] = result[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
