package baekjoon.math;

import java.util.Scanner;

public class Main06 {
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n != 0) {
                System.out.println(numCheck(n));
            } else {
                break;
            }
        }
    }

    public static int numCheck(int n) {
        ch = new int[(123456 * 2) + 1];
        int count = 0;
        for (int i = 2; i <= n * 2; i++) {
            if (ch[i] == 0) {
                if (i > n) {
                    count++;
                }
                for (int j = i; j <= n * 2; j = j + i) {
                    if (j % i == 0) {
                        ch[j] = 1;
                    }
                }
            }
        }
        return count;
    }
}
