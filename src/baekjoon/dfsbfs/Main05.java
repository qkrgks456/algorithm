package baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main05 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ints, ch;
    static int w, h;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        w = Integer.parseInt(strings[0]);
        h = Integer.parseInt(strings[1]);
        ints = new int[w][h];
        ch = new int[w][h];
        for (int i = 0; i < w; i++) {
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split("");
            for (int j = 0; j < h; j++) {
                ints[i][j] = Integer.parseInt(strings1[j]);
            }
        }
        BFS(0, 0);
        System.out.println(ch[w - 1][h - 1]);
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
                if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                    if (ints[nx][ny] == 1 && ch[nx][ny] == 0) {
                        ch[nx][ny] = ch[point.x][point.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
