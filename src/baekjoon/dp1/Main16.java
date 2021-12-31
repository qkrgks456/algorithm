package baekjoon.dp1;

import java.util.Arrays;
import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] ints = new int[n][2];
        int[][] ch = new int[n][k];
        for (int i = 0; i < n; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }

    }
}
