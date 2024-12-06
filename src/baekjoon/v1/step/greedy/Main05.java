package baekjoon.v1.step.greedy;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dt = new long[n - 1];
        long[] ints = new long[n];
        for (int i = 0; i < n - 1; i++) {
            dt[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        long num = ints[0];
        long ch = dt[0] * ints[0];
        for (int i = 1; i < n - 1; i++) {
            if (ints[i] < num) {
                num = ints[i];
            }
            ch += dt[i] * num;
        }
        System.out.println(ch);
    }
}
