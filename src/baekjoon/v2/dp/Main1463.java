package baekjoon.v2.dp;

import java.util.Scanner;

public class Main1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ints = new int[n + 1];
        ints[1] = 0;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + 1;
            if (i % 3 == 0) {
                ints[i] = Math.min(ints[i / 3] + 1, ints[i]);
            }
            if (i % 2 == 0) {
                ints[i] = Math.min(ints[i / 2] + 1, ints[i]);
            }
        }
        System.out.println(ints[n]);
    }
}
