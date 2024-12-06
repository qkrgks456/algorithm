package baekjoon.v1.etc3;

import java.util.Scanner;

public class Main11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] longs = new long[1001];
        longs[1] = 1;
        longs[2] = 3;
        longs[3] = 5;
        for (int i = 4; i < longs.length; i++) {
            longs[i] = (longs[i - 2] * 2 + longs[i - 1]) % 10007;
        }
        System.out.println(longs[n]);
    }
}
