package baekjoon.v1.etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main16234 {
    static int N, L, R;
    static int[][] ints, check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        int result = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        L = Integer.parseInt(strings[1]);
        R = Integer.parseInt(strings[2]);
        ints = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(strings1[j]);
            }
        }
        if (N == 1) {
            System.out.println(0);
            System.exit(0);
        }
        while (true) {
            check = new int[N][N];
            boolean stop = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j] == 0) {
                        if (move(i, j)) {
                            stop = false;
                        }
                    }
                }
            }
            if (stop) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    public static boolean move(int x, int y) {
        boolean checks = false;
        List<Point> list = new ArrayList();
        Queue<Point> queue = new LinkedList<>();
        int sum = ints[x][y];
        list.add(new Point(x, y));
        queue.add(new Point(x, y));
        check[x][y] = 1;
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && check[nx][ny] == 0) {
                    int m = Math.abs(ints[point.x][point.y] - ints[nx][ny]);
                    if (m >= L && m <= R) {
                        checks = true;
                        check[nx][ny] = 1;
                        sum += ints[nx][ny];
                        list.add(new Point(nx, ny));
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        if (list.size() != 0) {
            int n = sum / list.size();
            for (Point point : list) {
                ints[point.x][point.y] = n;
            }
        }
        return checks;
    }
}
