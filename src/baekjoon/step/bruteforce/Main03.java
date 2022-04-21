package baekjoon.step.bruteforce;

import java.util.Scanner;

public class Main03 {
    static int n = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ints[i][0] = x;
            ints[i][1] = y;
        }
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (ints[i][0] < ints[j][0] && ints[i][1] < ints[j][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
