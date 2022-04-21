package baekjoon.step.dp1;

import java.util.Scanner;

public class Main04 {
    static int num;
    static long[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ch = new long[100];
        ch[0] = 1;
        ch[1] = 1;
        ch[2] = 1;
        for (int j = 3; j < 100; j++) {
            ch[j] = ch[j - 2] + ch[j - 3];
        }
        for (int i = 0; i < n; i++) {
            num = scanner.nextInt();
            System.out.println(ch[num - 1]);
        }
    }
}
