package baekjoon.v2.graph;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14940 {
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    start = i;
                    end = j;
                }
            }
        }
        int[][] num = new int[n][m];
        int[][] check = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start, end));
        check[start][end] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int sx = point.x + nx[i];
                int sy = point.y + ny[i];
                if (sx >= 0 && sy >= 0 && sx < n && sy < m && check[sx][sy] == 0 && graph[sx][sy] != 0) {
                    check[sx][sy] = 1;
                    num[sx][sy] = num[point.x][point.y] + 1;
                    queue.add(new Point(sx, sy));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {  // 이동할 수 없는 지점은 0으로 출력
                    sb.append(0).append(" ");
                } else if (check[i][j] == 0) {  // 도달할 수 없는 지점은 -1로 출력
                    sb.append(-1).append(" ");
                } else {
                    sb.append(num[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
