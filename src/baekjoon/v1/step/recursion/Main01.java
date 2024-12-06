package baekjoon.v1.step.recursion;

import java.util.Scanner;

public class Main01 {
    // 팩토리얼 재귀적으로 할만하다
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(recursion(n));
    }

    public static int recursion(int n) {
        if (n < 1) {
            return 1;
        } else {
            return recursion(n - 1) * n;
        }
    }
}
