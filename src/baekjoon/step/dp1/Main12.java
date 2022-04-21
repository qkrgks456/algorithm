package baekjoon.step.dp1;

import java.util.Scanner;


// 진짜 너무 어렵다 이거는
// 골3의 문제인가 이게
// 풀이봐도 이해도 안되고 그냥 화딱지 개나네
// LIS 활용이라는데 LIS를 이해하지 못한건가 너무 어렵네
public class Main12 {
    static int[] ints, ch1, ch2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new int[n];
        ch1 = new int[n];
        ch2 = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            ch1[i] = 1;
            for (int j = 0; j < i; j++) {
                // 여기 두번째 조건이 핵 킹 받는다
                if (ints[i] > ints[j] && ch1[i] < ch1[j] + 1) {
                    ch1[i] = ch1[j] + 1;
                }
            }
        }
        // 거꾸로는 알겠다
        for (int i = n - 1; i >= 0; i--) {
            ch2[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (ints[i] > ints[j] && ch2[i] < ch2[j] + 1) {
                    ch2[i] = ch2[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(ch1[i] + ch2[i], max);
        }
        System.out.println(max - 1);
    }
}
