package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        // 이전 연산에 1을 더할지
        // 아 이거는 그림으로 그려야 된다
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n + 1];
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 1] + 1;
            if (i % 3 == 0) {
                ints[i] = Math.min(ints[i / 3] + 1, ints[i]);
            }
            if (i % 2 == 0) {
                ints[i] = Math.min(ints[i / 2] + 1, ints[i]);
            }

        }
        System.out.println(ints[n]);
    }
}
