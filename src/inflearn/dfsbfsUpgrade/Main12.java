package inflearn.dfsbfsUpgrade;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main12 {
    static int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[][] ints, ch;
    static int n;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1 && ch[i][j] == 0) {
                    result++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(result);
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        ch[x][y] = 1;
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 8; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && ints[nx][ny] == 1) {
                    ch[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
