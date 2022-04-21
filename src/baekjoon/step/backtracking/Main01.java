package baekjoon.step.backtracking;

import java.util.Scanner;

public class Main01 {
    static int n, n1;
    static int ch[], result[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        n1 = scanner.nextInt();
        ch = new int[n + 1];
        result = new int[n1];
        recursion(0);
    }

    public static void recursion(int num) {
        if (n1 == num) {
            for (int n1 : result) {
                System.out.print(n1 + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    result[num] = i;
                    recursion(num + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
