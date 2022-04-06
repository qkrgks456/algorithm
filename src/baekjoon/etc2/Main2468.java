package baekjoon.etc2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
    static int[][] ch;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[N][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                max = Math.max(max, ints[i][j]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= max; i++) {
            int count = 0;
            ch = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ints[j][k] <= i) {
                        ch[j][k] = 1;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ch[j][k] == 0) {
                        BFS(j, k);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
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
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
