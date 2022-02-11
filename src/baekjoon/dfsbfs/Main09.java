package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main09 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ints, dis;
    static int[][][] ch;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }
        ints = new int[n][m];
        dis = new int[n][m];
        ch = new int[2][n][m];
        for (int i = 0; i < n; i++) {
            String s1 = bufferedReader.readLine();
            String[] strings1 = s1.split("");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(strings1[j]);
                ints[i][j] = num;
            }
        }
        BFS();
    }

    public static void BFS() {
        int nx, ny;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        ch[0][0][0] = 1;
        ch[1][0][0] = 1;
        dis[0][0] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 벽일때
                    if (ints[nx][ny] == 1) {
                        if (point.check == 0 && ch[1][nx][ny] == 0) {
                            ch[1][nx][ny] = 1;
                            dis[nx][ny] = dis[point.x][point.y] + 1;
                            queue.add(new Point(nx, ny, 1));
                        }
                    } else { //벽이 아닐때 여기 부분이 햇갈리는데 ?
                        if (ch[point.check][nx][ny] == 0) {
                            ch[point.check][nx][ny] = 1;
                            dis[nx][ny] = dis[point.x][point.y] + 1;
                            queue.add(new Point(nx, ny, point.check));
                        }
                    }
                }
                if (nx == n - 1 && ny == m - 1) {
                    System.out.println(dis[nx][ny]);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);
    }

    static class Point {
        int x;
        int y;
        int check;

        public Point(int x, int y, int check) {
            this.x = x;
            this.y = y;
            this.check = check;
        }
    }
}
