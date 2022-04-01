package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16918 {
    static int r, c, n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int time = 1;
        chars = new char[r][c];
        int[][] check = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                chars[i][j] = s.charAt(j);
                if (chars[i][j] == 'O') {
                    check[i][j] = 1;
                }
            }
        }
        if (n == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(chars[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        while (true) {
            time++;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    chars[j][k] = 'O';
                    check[j][k]++;
                }
            }
            if (time == n) break;
            time++;
            check = bomb(check);
            if (time == n) break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                stringBuilder.append(chars[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    // 아 저거 상태유지를 어떻게 하지
    public static int[][] bomb(int[][] check) {
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = check[i][j];
            }
        }
        for (int j = 0; j < r; j++) {
            for (int k = 0; k < c; k++) {
                check[j][k]++;
                if (check[j][k] == 3) {
                    chars[j][k] = '.';
                    result[j][k] = 0;
                    int nx, ny;
                    for (int i = 0; i < 4; i++) {
                        nx = j + dx[i];
                        ny = k + dy[i];
                        if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                            chars[nx][ny] = '.';
                            result[nx][ny] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
}
