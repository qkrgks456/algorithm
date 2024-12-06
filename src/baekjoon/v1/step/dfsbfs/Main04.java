package baekjoon.v1.step.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main04 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ints, ch;
    static int width, height, count;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            width = Integer.parseInt(strings[0]);
            height = Integer.parseInt(strings[1]);
            count = Integer.parseInt(strings[2]);
            ints = new int[width][height];
            ch = new int[width][height];
            int result = 0;
            for (int j = 0; j < count; j++) {
                String s1 = bufferedReader.readLine();
                String[] strings1 = s1.split(" ");
                ints[Integer.parseInt(strings1[0])][Integer.parseInt(strings1[1])] = 1;
            }
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    if (ints[j][k] == 1 && ch[j][k] == 0) {
                        BFS(j, k);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void BFS(int x, int y) {
        int nx, ny;
        Queue<Point> queue = new LinkedList<>();
        ch[x][y] = 1;
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    if (ints[nx][ny] == 1 && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
