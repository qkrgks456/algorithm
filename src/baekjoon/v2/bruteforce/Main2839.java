package baekjoon.v2.bruteforce;

import java.util.Scanner;

public class Main2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 5로 나눠지면 어차피 봉투개수가 최소임
        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 5; i <= n; i += 5) {
            if ((n - i) % 3 == 0) {
                int num = i / 5;
                result = Math.min(((n - i) / 3) + num, result);
            }
        }

        for (int i = 3; i <= n; i += 3) {
            if (n % i == 0) {
                result = Math.min(n / 3, result);
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
}
