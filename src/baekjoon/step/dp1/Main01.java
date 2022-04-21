package baekjoon.step.dp1;

import java.util.Scanner;

public class Main01 {
    static int ch[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            ch = new int[n1 + 1];
            if (n1 == 0) {
                System.out.println("1 0");
            } else if (n1 == 1) {
                System.out.println("0 1");
            } else {
                int one = fibo(n1);
                int zero = fibo(n1 - 1);
                System.out.println(zero + " " + one);
            }
        }
    }

    // 1 1 2 3 5 8 13 21 34
    public static int fibo(int num) {
        if (ch[num] != 0) {
            return ch[num];
        }
        if (num == 0) {
            return ch[num] = 0;
        } else if (num == 1) {
            return ch[num] = 1;
        } else {
            return ch[num] = fibo(num - 1) + fibo(num - 2);
        }
    }
}
