package baekjoon.etc2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main17141 {
    static List<Point> list = new ArrayList<>();
    static int[] ch, result;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ints, check, count;
    static int resultMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (ints[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }
        ch = new int[list.size()];
        choice(0, 0);
        if (resultMin == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(resultMin);
        }
    }

    public static void choice(int level, int idx) {
        if (level == M) {
            Queue<Point> queue = new LinkedList<>();
            check = new int[N][N];
            count = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    check[i][j] = ints[i][j];
                }
            }
            for (int n : result) {
                Point point = list.get(n);
                queue.add(point);
                check[point.x][point.y] = 1;
            }
            BFS(queue);
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                result[level] = i;
                choice(level + 1, i);
                ch[i] = 0;
            }
        }
    }

    public static void BFS(Queue<Point> queue) {
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && check[nx][ny] != 1) {
                    check[nx][ny] = 1;
                    count[nx][ny] = count[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        boolean checks = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, count[i][j]);
                if (check[i][j] == 0) {
                    checks = false;
                }
            }
        }
        if (checks) {
            resultMin = Math.min(max, resultMin);
        }
    }
}
