package baekjoon.etc2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16956 {
    static List<Point> list;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static char[][] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        chars = new char[R][C];
        list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                chars[i][j] = s.charAt(j);
                if (chars[i][j] == 'W') {
                    list.add(new Point(i, j));
                }
            }
        }
        search();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1 + "\n");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                stringBuilder.append(chars[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void search() {
        int nx, ny;
        for (Point point : list) {
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (chars[nx][ny] == 'S') {
                        System.out.println(0);
                        System.exit(0);
                    } else if (chars[nx][ny] == '.') {
                        chars[nx][ny] = 'D';
                    }
                }
            }
        }
    }
}
