package baekjoon.step.divideConquer;

import java.util.Scanner;

public class Main07 {
    static int n;
    static int[][] ints;

    public static void main(String[] args) {
        // 이전 행렬 잘 참고하면 할만했다
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        long m = scanner.nextLong();
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = scanner.nextInt() % 1000;
            }
        }
        int[][] result = DFS(m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] DFS(long num) {
        if (num == 1) {
            return ints;
        }
        int[][] good = DFS(num / 2);
        if (num % 2 == 0) {
            return multi(good, good);
        } else {
            return multi(multi(good, good), ints);
        }
    }

    public static int[][] multi(int[][] matrix, int[][] matrix2) {
        int[][] result = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                int r = matrix[i][k];
                for (int j = 0; j < n; j++) {
                    result[i][j] = (result[i][j] + r * matrix2[k][j] % 1000) % 1000;
                }
            }
        }
        return result;
    }
}
