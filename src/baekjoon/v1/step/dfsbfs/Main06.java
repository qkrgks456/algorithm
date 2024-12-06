package baekjoon.v1.step.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main06 {
    static int m, n;
    static int[][]  ch, result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        m = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        ch = new int[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(strings1[j]);
                if (num == 1) {
                    queue.add(new Point(i, j));
                    ch[i][j] = 1;
                } else if (num == -1) {
                    ch[i][j] = 1;
                }
            }
        }
        BFS();
        boolean check = true;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < result[i][j]) {
                    max = result[i][j];
                }
                if (ch[i][j] == 0) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }

    public static void BFS() {
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                        result[nx][ny] = result[point.x][point.y] + 1;
                    }
                }
            }
        }
    }
}
