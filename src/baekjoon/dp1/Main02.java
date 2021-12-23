package baekjoon.dp1;

import java.util.Scanner;

public class Main02 {
    static int[] ch;
    static int[][][] elseCh;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ch = new int[21];
        ch[0] = 1;
        for (int i = 1; i < ch.length; i++) {
            ch[i] = ch[i - 1] * 2;
        }
        while (true) {
            count = 0;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a == -1 && b == -1 && c == -1) {
                break;
            } else if (a < 0 || b < 0 || c < 0) {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = 1");
            } else {
                elseCh = new int[a + 1][b + 1][c + 1];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("w(" + a + ", " + b + ", " + c + ") = ");
                stringBuilder.append(w(a, b, c));
                System.out.println(stringBuilder);
            }
        }
    }

    public static int w(int a, int b, int c) {
        if (elseCh[a][b][c] != 0) {
            return elseCh[a][b][c];
        }
        if (a == b && a == c && a < 21) {
            return ch[a];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return ch[20];
        } else if (a < b && b < c) {
            // w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
            return ch[a];
        } else {
            return elseCh[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }
}
