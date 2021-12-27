package baekjoon.dp1;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int n = scanner.nextInt();
        int[] ints = new int[n];
        int[] p = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        System.out.println(max);
    }
}
