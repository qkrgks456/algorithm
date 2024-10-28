package baekjoon.v2.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[][] graph = new int[n][m];
            int[][] check = new int[n][m];
            for (int j = 0; j < k; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                graph[y][x] = 1;
            }

            int result = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (check[j][l] == 0 && graph[j][l] == 1) {
                        result++;
                        check[j][l] = 1;
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(j, l));
                        while (!queue.isEmpty()) {
                            Point point = queue.poll();
                            for (int o = 0; o < 4; o++) {
                                int sx = point.x + nx[o];
                                int sy = point.y + ny[o];
                                if (sx >= 0 && sy >= 0 && sx < n && sy < m && graph[sx][sy] == 1 && check[sx][sy] == 0) {
                                    check[sx][sy] = 1;
                                    queue.add(new Point(sx, sy));
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
