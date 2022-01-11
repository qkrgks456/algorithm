package baekjoon.divideConquer;

import java.util.Scanner;

public class Main01 {
    static int[][] ints;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        // 분할 정복 스타트
        // 재귀는 진짜 개 열받네
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new int[n][n];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        DFS(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void DFS(int x, int y, int n) {
        if (colorCheck(x, y, n)) {
            if (ints[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 아 이해안됨 망했네 ㅋㅋ
        int size = n / 2;
        DFS(x, y, size); // 2사분면
        DFS(x, y + size, size); // 3사분면
        DFS(x + size, y, size); // 1사분면
        DFS(x + size, y + size, size); // 4사분면

    }

    public static boolean colorCheck(int x, int y, int n) {
        int check = ints[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (ints[i][j] != check) {
                    return false;
                }
            }
        }
        return true;
    }
}
