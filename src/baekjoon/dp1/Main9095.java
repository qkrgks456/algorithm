package baekjoon.dp1;

import java.util.Scanner;

public class Main9095 {
    public static void main(String[] args) {
        int[] ints = new int[11];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints[1] = 1;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 1] + i - 1;
        }
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

        }
    }
}
