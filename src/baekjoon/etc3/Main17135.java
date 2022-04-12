package baekjoon.etc3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17135 {
    static int[][] ints, check;
    static int N, M, D;
    static int[] location;
    static int[] ch;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};
    static Queue<Point> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        D = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        location = new int[3];
        ch = new int[M];
        // 일단 경우의 수 뽑기 3명 놓는거
        DFS(0, 0);
    }

    public static void DFS(int level, int idx) {
        if (level == 3) {
            check = new int[N][M];
            queue = new LinkedList<>();
            for (int n : location) {
                check[N - 1][n] = 1;
                queue.add(new Point(N - 1, n));
            }
            defense();
            return;
        }

        for (int i = idx; i < M; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                location[level] = i;
                DFS(level + 1, i);
                ch[i] = 0;
            }
        }
    }

    public static void defense() {
        int nx, ny;
        int count = 0;
        int idx = 0;
        while (true) {
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                // 내 자리가 병사면 죽여
                if (ints[point.x][point.y] == 1) {
                    ints[point.x][point.y] = 0;
                    count++;
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    nx = point.x + dx[k];
                    ny = point.y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < D && check[nx][ny] == 0) {
                        check[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            // 적들 진격하라
            for (int i = N - 2; i >= idx; i--) {
                for (int j = 0; j < M; j++) {
                    ints[i + 1][j] = ints[i][j];
                }
            }
            idx++;
            if (idx == N - 1) {
                break;
            }
        }
    }
}
