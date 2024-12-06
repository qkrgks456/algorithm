package baekjoon.v1.etc3;

import java.util.Scanner;

public class Main2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] longs = new long[91];
        longs[1] = 1;
        longs[2] = 1;
        for (int i = 3; i <= 90; i++) {
            longs[i] = longs[i - 1] + longs[i - 2];
        }
        System.out.println(longs[N]);
    }
}
