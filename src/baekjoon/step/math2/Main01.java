package baekjoon.step.math2;

import java.util.Scanner;

public class Main01 {
    static int[] ints;
    static int[] decimal;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ch = new int[2];
        ch[0] = 2;
        decimal(10000);
        int l = 0;
        int r = 0;
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            l = n / 2;
            r = n / 2;
            while (true) {
                if (decimal[l] == 1 && decimal[r] == 1) {
                    System.out.println(l + " " + r);
                    break;
                }
                l--;
                r++;
            }
        }
    }

    public static void decimal(int n) {
        ints = new int[10001];
        decimal = new int[10001];
        for (int i = 2; i <= n; i++) {
            if (ints[i] == 0) {
                decimal[i] = 1;
                for (int j = i; j <= n; j = j + i) {
                    if (j % i == 0) {
                        ints[j] = 1;
                    }
                }
            }
        }
    }
}
