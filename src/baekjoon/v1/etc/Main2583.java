package baekjoon.v1.etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main2583 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> list = new ArrayList<>();
    static int m, n, k;
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        m = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);
        k = Integer.parseInt(strings[2]);
        ints = new int[m][n];
        for (int i = 0; i < k; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            int startX = Integer.parseInt(strings1[0]);
            int startY = Integer.parseInt(strings1[1]);
            int endX = Integer.parseInt(strings1[2]);
            int endY = Integer.parseInt(strings1[3]);
            for (int l = startY; l < endY; l++) {
                for (int j = startX; j < endX; j++) {
                    ints[l][j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 0) {
                    count++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int n : list) {
            System.out.print(n + " ");
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        ints[x][y] = 1;
        int nx, ny;
        int check = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            check++;
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && ints[nx][ny] == 0) {
                    ints[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        list.add(check);
    }
}
