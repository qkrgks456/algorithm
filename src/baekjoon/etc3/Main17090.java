package baekjoon.etc3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17090 {
    static int N, M;
    static int[][] check;
    static char[][] chars;
    static int count = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        chars = new char[N][M];
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        // 일단 모서리 탈출 가능한곳 뽑기 4방향다
        for (int i = 0; i < N; i++) {
            if (chars[i][M - 1] == 'R') {
                check[i][M - 1] = 1;
                queue.add(new Point(i, M - 1));
                count++;
            }
            if (chars[i][0] == 'L') {
                check[i][0] = 1;
                queue.add(new Point(i, 0));
                count++;
            }
        }
        for (int i = 0; i < M; i++) {
            if (chars[0][i] == 'U') {
                check[0][i] = 1;
                queue.add(new Point(0, i));
                count++;
            }
            if (chars[N - 1][i] == 'D') {
                check[N - 1][i] = 1;
                queue.add(new Point(N - 1, i));
                count++;
            }
        }
        BFS();
        System.out.println(count);
    }

    public static void BFS() {
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && check[nx][ny] == 0) {
                    switch (chars[nx][ny]) {
                        case 'R':
                            if (ny + 1 == point.y) {
                                check[nx][ny] = 1;
                                queue.add(new Point(nx, ny));
                                count++;
                            }
                            break;
                        case 'L':
                            if (ny - 1 == point.y) {
                                check[nx][ny] = 1;
                                queue.add(new Point(nx, ny));
                                count++;
                            }
                            break;
                        case 'U':
                            if (nx - 1 == point.x) {
                                check[nx][ny] = 1;
                                queue.add(new Point(nx, ny));
                                count++;
                            }
                            break;
                        case 'D':
                            if (nx + 1 == point.x) {
                                check[nx][ny] = 1;
                                queue.add(new Point(nx, ny));
                                count++;
                            }
                            break;
                    }
                }
            }
        }
    }
}
