package baekjoon.step.divideConquer;

import java.util.Scanner;

public class Main06 {
    // 행렬 받는거 은근 빡치네
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[][] first;
        int[][] second;
        int[][] result;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        first = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                first[i][j] = scanner.nextInt();
            }
        }
        int num = scanner.nextInt();
        int k = scanner.nextInt();
        second = new int[num][k];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < k; j++) {
                second[i][j] = scanner.nextInt();
            }
        }
        result = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    result[i][j] += first[i][l] * second[l][j];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                stringBuilder.append(result[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
