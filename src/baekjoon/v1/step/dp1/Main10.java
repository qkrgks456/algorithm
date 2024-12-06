package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        // 포도주 메타 일텐데
        // 3가지 조건 만족하는 가장 큰놈
        // 0X0 <- 마지막 전잔 안 먹을때
        // 0X00 <- 마지막 전잔 먹을때
        // 0X <- 마지막 잔 안 먹을때
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n + 1];
        int[] ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = scanner.nextInt();
        }
        ch[1] = ints[1];
        if (n != 1) {
            ch[2] = ints[1] + ints[2];
        }
        for (int i = 3; i <= n; i++) {
            ch[i] = Math.max(ch[i - 3] + ints[i - 1] + ints[i], Math.max(ch[i - 1], ch[i - 2] + ints[i]));
        }
        if (n != 1) {
            System.out.println(ch[n]);
        } else {
            System.out.println(ch[1]);
        }
    }
}
