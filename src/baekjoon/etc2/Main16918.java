package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16918 {
    static int r, c, n;
    static int[][] check, result;
    static char[][] chars;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int time = 1;
        chars = new char[r][c];
        check = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                chars[i][j] = s.charAt(j);
                if (chars[i][j] == 'O') {
                    check[i][j] = 1;
                }
            }
        }
        while (true) {
            time++;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (chars[j][k] == 'O') {
                        check[j][k]++;
                    } else {
                        chars[j][k] = 'O';
                    }
                }
            }
            if (time == n) break;
            time++;
            result = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    check[j][k]++;
                    if (check[j][k] == 3) {
                        bomb(j, k);
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (result[i][j] == 1) {
                        check[i][j] = 0;
                    }
                }
            }
            if (time == n) break;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }

    }

    public static void bomb(int x, int y) {
        chars[x][y] = '.';
        check[x][y] = 0;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                chars[nx][ny] = '.';
                result[nx][ny] = 1;
            }
        }
    }
}
