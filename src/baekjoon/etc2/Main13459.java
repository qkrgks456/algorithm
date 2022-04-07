package baekjoon.etc2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13459 {
    static int N, M, count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Point arrive, B;
    static char[][] chars;
    static int[][] ch;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        chars = new char[N][M];
        ch = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                chars[i][j] = s.charAt(j);
                if (chars[i][j] == 'O') {
                    arrive = new Point(i, j);
                } else if (chars[i][j] == 'R') {
                    ch[i][j] = 2;
                    queue.add(new Point(i, j));
                } else if (chars[i][j] == 'B') {
                    ch[i][j] = 2;
                    B = new Point(i, j);
                } else if (chars[i][j] == '#') {
                    ch[i][j] = 1;
                }
            }
        }
    }

    public static void BFS() {
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && ch[nx][ny] == 0) {
                    if (i == 0) {
                        // 위
                        ch[point.x][point.y] = 0;
                        while (ch[nx][ny] < 1) {
                            if (chars[nx][ny] == 'O') {
                                System.exit(0);
                            }
                            nx--;
                        }
                        queue.add(new Point(nx + 1, ny));
                    } else if (i == 1) {
                        // 왼쪽
                        ch[point.x][point.y] = 0;
                        while (ch[nx][ny] < 1) {
                            if (chars[nx][ny] == 'O') {
                                System.exit(0);
                            }
                            ny--;
                        }
                        queue.add(new Point(nx, ny + 1));
                    } else if (i == 2) {
                        // 아래
                        ch[point.x][point.y] = 0;
                        while (ch[nx][ny] < 1) {
                            if (chars[nx][ny] == 'O') {
                                System.exit(0);
                            }
                            nx++;
                        }
                        queue.add(new Point(nx - 1, ny));
                    } else {
                        // 오른쪽
                        ch[point.x][point.y] = 0;
                        while (ch[nx][ny] < 1) {
                            if (chars[nx][ny] == 'O') {
                                System.exit(0);
                            }
                            ny++;
                        }
                        queue.add(new Point(nx, ny - 1));
                    }
                }
            }
        }
    }
}
