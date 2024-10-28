package baekjoon.v2.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                max = Math.max(max, ints[i][j]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= max; i++) {
            int[][] check = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (ints[j][k] <= i) check[j][k] = 1;
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (check[j][k] == 0) {
                        check[j][k] = 1;
                        count++;
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(j, k));
                        while (!queue.isEmpty()) {
                            Point point = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int sx = point.x + nx[l];
                                int sy = point.y + ny[l];
                                if (sx >= 0 && sy >= 0 && sx < n && sy < n && check[sx][sy] == 0) {
                                    check[sx][sy] = 1;
                                    queue.add(new Point(sx, sy));
                                }
                            }
                        }
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);

    }
}
