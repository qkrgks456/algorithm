package baekjoon.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20057 {
    static int[][] ints;
    static int total = 0;
    static int[] dx = {1, -1, 2, -2, 0};
    static int[] dy = {1, 1, 0, 0, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        // 토네이도의 이동
        int x = n / 2;
        int y = n / 2;
        int check = 1;
        boolean ch = true;
        boolean ch2 = true;
        while (true) {
            for (int i = 0; i < check; i++) {
                if (ch2) {
                    y--;
                    send(x, y, 1);
                } else {
                    y++;
                    send(x, y, 3);
                }
            }
            ch2 = !ch2;
            for (int i = 0; i < check; i++) {
                if (ch) {
                    x++;
                    send(x, y, 2);
                } else {
                    x--;
                    send(x, y, 4);
                }
            }
            ch = !ch;
            // 마지막 줄 처리
            if (check == n - 1) {
                for (int i = 0; i < check; i++) {
                    y--;
                    send(x, y, 1);
                }
                break;
            }
            check++;
        }

    }

    public static void send(int x, int y, int direction) {
        // 이걸 먼저 나누자 퍼센트별로
        int send = ints[x][y];
        int one = (int) (send * 1.0 / 100);
        int two = (int) (send * 2.0 / 100);
        int five = (int) (send * 5.0 / 100);
        int seven = (int) (send * 7.0 / 100);
        int ten = (int) (send * 10.0 / 100);
        int alpha = send - one * 2 - two * 2 - seven * 2 - ten * 2 - five;
        int nx, ny;
        switch (direction) {
            case 1:
                // 서
                break;
            case 2:
                // 남

                break;
            case 3:
                // 동

                break;
            case 4:
                // 북

                break;
        }
    }
}
