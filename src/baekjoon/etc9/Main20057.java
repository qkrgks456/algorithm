package baekjoon.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20057 {
    static int n;
    static int[][] ints;
    static int total = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 1, 2 ,7, 10
    static int[][] dx2 = {{1, -1, -2, 2, -1, 1, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {-1, 1, -2, 2, -1, 1, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dy2 = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, 2, -2, 1, -1, 1, -1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, -2, 1, -1, -1, 1, 0}};
    static double[] ch = {1.0, 1.0, 2.0, 2.0, 7.0, 7.0, 10.0, 10.0, 5.0};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
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
                    send(x, y, 0);
                } else {
                    y++;
                    send(x, y, 2);
                }
            }
            ch2 = !ch2;
            for (int i = 0; i < check; i++) {
                if (ch) {
                    x++;
                    send(x, y, 1);
                } else {
                    x--;
                    send(x, y, 3);
                }
            }
            ch = !ch;
            // 마지막 줄 처리
            if (check == n - 1) {
                for (int i = 0; i < check; i++) {
                    y--;
                    send(x, y, 0);
                }
                break;
            }
            check++;
        }
        System.out.println(total);
    }

    public static void send(int x, int y, int direction) {
        int send = ints[x][y];
        int alpha = send;
        int nx2, ny2;
        for (int i = 0; i < 9; i++) {
            nx2 = x + dx2[direction][i];
            ny2 = y + dy2[direction][i];
            int percent = (int) (send * ch[i] / 100);
            if (nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < n) {
                // 모래 안 나갈때
                ints[nx2][ny2] += percent;
            } else {
                // 모래 나갈때
                total += percent;
            }
            alpha -= percent;
        }
        // alpha만 체크
        int ax, ay;
        ax = x + dx[direction];
        ay = y + dy[direction];
        if (ax >= 0 && ay >= 0 && ax < n && ay < n) {
            ints[ax][ay] += alpha;
        } else {
            total += alpha;
        }
    }
}
