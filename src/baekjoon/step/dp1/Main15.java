package baekjoon.step.dp1;

import java.util.Scanner;

public class Main15 {
    // 쉬운줄 알았는데 개 열받게 하네 ㅋㅋ 다시 DP적으로 푼다 개 열받누
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int ch[] = new int[n];
        ch[0] = ints[0];
        int max = ch[0];
        for (int i = 1; i < ch.length; i++) {
            // 최대합이랑 자기랑 비교해서 넣자
            ch[i] = Math.max(ch[i - 1] + ints[i], ints[i]);
            // 해당 최대합 배열 최댓값 구하면 끝 심플
            max = Math.max(ch[i], max);
        }
        System.out.println(max);
    }
}
