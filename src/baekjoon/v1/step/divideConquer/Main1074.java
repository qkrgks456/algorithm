package baekjoon.v1.step.divideConquer;

import java.util.Scanner;

public class Main1074 {
    static int r, c;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arraySize = (int) Math.pow(2, n);
        r = scanner.nextInt();
        c = scanner.nextInt();
        recursion(0, 0, arraySize);
        System.out.println(count);
    }

    public static void recursion(int x, int y, int num) {
        if (x == r && y == c) {
            System.out.println(count);
            System.exit(0);
        }

        // 똑같은데 ? 조건이 중나 어렵네
        if (x <= r && y <= c && x + num > r && y + num > c) {
            int size = num / 2;
            for (int i = x; i < x + num; i += size) {
                for (int j = y; j < y + num; j += size) {
                    recursion(i, j, size);
                }
            }
        } else {
            count += num * num;
        }
    }
}
