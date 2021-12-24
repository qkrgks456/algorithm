package baekjoon.dp1;

import java.util.Scanner;

public class Main07 {
    static int root, n;
    static int[] ints;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = scanner.nextInt();
        }
        int count = 0;
        int result = 0;
        int num = 0;
        while (true) {
            if (ints[num + 1] > ints[num + 2]) {
                count++;
                num++;
            } else {
                count = 0;
                num += 2;
            }
            result += Math.max(ints[num + 1], ints[num + 2]);
        }
    }
}
