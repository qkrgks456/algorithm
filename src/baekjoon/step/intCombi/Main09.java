package baekjoon.step.intCombi;

import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] cb = new long[31][31];
        cb[1][0] = 1;
        cb[1][1] = 1;
        for (int i = 2; i < cb.length; i++) {
            cb[i][0] = 1;
            cb[i][i] = 1;
            for (int j = 1; j <= i; j++) {
                cb[i][j] = cb[i - 1][j - 1] + cb[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            System.out.println(cb[n2][n1]);
        }
    }
}
