package baekjoon.etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1987 {
    static int r, c;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] graph;
    static int[][] result;
    static int[] ch2 = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        graph = new char[r][c];
        for (int i = 0; i < r; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j = 0; j < c; j++) {
                graph[i][j] = strings[j].charAt(0);
            }
        }
        System.out.println('z' - 97);
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        result[0][0] = 1;
        ch2[graph[0][0] - 97] = 1;
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (ch2[graph[nx][ny] - 97] == 0) {
                        ch2[graph[nx][ny] - 97] = 1;

                    }
                }
            }
        }
    }
}
