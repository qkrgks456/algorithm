package baekjoon.v1.etc8;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573 {
    static int n, m;
    static int[][] ch, melt, ints;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int result = 0;
        while (true) {
            if (arrayCheck()) {
                System.out.println(result);
                break;
            }
            melt();
            result++;
        }
    }

    public static void melt() {
        melt = new int[n][m];
        int nx, ny;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (ints[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if (ints[nx][ny] < 1) {
                            melt[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ints[i][j] -= melt[i][j];
            }
        }
    }

    public static boolean arrayCheck() {
        ch = new int[n][m];
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (ints[i][j] > 0 && ch[i][j] == 0) {
                    count++;
                    BFS(i, j);
                }
            }
        }
        if (count > 1) {
            return true;
        } else if (count == 0) {
            System.out.println(0);
            System.exit(0);
        }
        return false;
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int nx, ny;
        ch[x][y] = 1;
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx < n - 1 && ny < m - 1 && ch[nx][ny] == 0 && ints[nx][ny] > 0) {
                    ch[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
