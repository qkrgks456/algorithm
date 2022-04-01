package baekjoon.etc2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main11559 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] chars;
    static int[][] check;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        chars = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < 6; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        while (true) {
            boolean stopCheck = true;
            check = new int[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (check[i][j] == 0 && chars[i][j] != '.') {
                        if (BFS(i, j)) {
                            stopCheck = false;
                        }
                    }
                }
            }
            // 아얘 안 터졌으면 멈춰!
            if (stopCheck) {
                System.out.println(result);
                break;
            } else {
                // 터졌으면 1연쇄
                result++;
            }
            // 애들 내리기
            while (true) {
                boolean stopCheck2 = true;
                for (int i = 0; i < 6; i++) {
                    for (int j = 11; j > 0; j--) {
                        if (chars[j][i] == '.' && chars[j - 1][i] != '.') {
                            chars[j][i] = chars[j - 1][i];
                            chars[j - 1][i] = '.';
                            stopCheck2 = false;
                        }
                    }
                }
                if (stopCheck2) {
                    break;
                }
            }
        }
    }

    public static boolean BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        list.add(new Point(x, y));
        queue.add(new Point(x, y));
        check[x][y] = 1;
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && check[nx][ny] == 0 && chars[x][y] == chars[nx][ny] && chars[nx][ny] != '.') {
                    check[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                    list.add(new Point(nx, ny));
                }
            }
        }
        if (list.size() >= 4) {
            for (Point point : list) {
                chars[point.x][point.y] = '.';
            }
            return true;
        }
        return false;
    }
}
