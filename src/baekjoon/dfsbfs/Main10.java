package baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10 {
    static int[][] result, ch;
    static int endX, endY, num;
    static int[] dx = {-1, 1, -1, 1, 2, 2, -2, -2};
    static int[] dy = {2, 2, -2, -2, -1, 1, -1, 1};
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(bufferedReader.readLine());
            result = new int[num][num];
            ch = new int[num][num];
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            int startX = Integer.parseInt(strings[0]);
            int startY = Integer.parseInt(strings[1]);
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split(" ");
            endX = Integer.parseInt(strings1[0]);
            endY = Integer.parseInt(strings1[1]);
            if (startX == endX && startY == endY) {
                stringBuilder.append(0 + "\n");
                continue;
            }
            BFS(startX, startY);
        }
        System.out.println(stringBuilder);
    }

    static void BFS(int x, int y) {
        int nx, ny;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 8; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < num && ny < num) {
                    if (ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        result[nx][ny] = result[point.x][point.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
                if (nx == endX && ny == endY) {
                    stringBuilder.append(result[nx][ny] + "\n");
                    return;
                }
            }
        }
    }
}
