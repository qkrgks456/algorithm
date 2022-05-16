package baekjoon.etc5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026 {
    static int n;
    static int[][] ch;
    static char[][] chars;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        chars = new char[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        // 적녹색약이 아닐때
        int count1 = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (ch[i][j] == 0) {
                    ch[i][j] = 1;
                    count1++;
                    BFS(chars[i][j], i, j);
                }
            }
        }
        // 적녹 색약일때
        int count2 = 0;
        ch = new int[n][n];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (ch[i][j] == 0) {
                    ch[i][j] = 1;
                    if (chars[i][j] == 'B') {
                        BFS(chars[i][j], i, j);
                    } else {
                        BFS2(i, j);
                    }
                    count2++;
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }

    public static void BFS(char check, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (ch[nx][ny] == 0 && chars[nx][ny] == check) {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void BFS2(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (ch[nx][ny] == 0 && chars[nx][ny] != 'B') {
                        ch[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
