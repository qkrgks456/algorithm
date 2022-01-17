package baekjoon.divideConquer;

import java.util.Scanner;

public class Main06 {
    static int[][] first;
    static int[][] second;
    static int[][] result;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            int n = scanner.nextInt();
            int n1 = scanner.nextInt();
            if (i == 0) {
                first = new int[n][n1];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n1; k++) {
                        first[j][k] = scanner.nextInt();
                    }
                }
            } else {
                second = new int[n][n1];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n1; k++) {
                        second[j][k] = scanner.nextInt();
                    }
                }
            }
        }
        DFS(0, 0);
    }

    public static int DFS(int x, int y) {

        return DFS(x, y) * DFS(x, y);
    }
}
