package baekjoon.backtracking;

import java.util.Scanner;

public class Main05 {
    static int n, maxCount = 0;
    static int[][] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ch = new int[n][n];
        if (n < 4) {
            System.out.println(0);
        } else if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    DFS(i, j, 0);
                }
            }
            System.out.println(maxCount * 4);
        } else if (n % 2 != 0) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < n / 2 + 1; j++) {
                    DFS(i, j, 0);
                }
            }
        }

    }

    public static void DFS(int x, int y, int count) {
        if (count == 3) {
            return;
        }
        for (int i = 0; i < n; i++) {
            ch[x][i] = 1;
            ch[i][y] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0) {
                    DFS(i, j, count + 1);
                }
            }
        }
    }
}
