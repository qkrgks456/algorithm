package baekjoon.recursion;

import java.util.Scanner;

public class Main02 {
    // 피보나치 수열은 킹만하다
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(recursion(n));
    }

    public static int recursion(int num) {
        if (num <= 1) {
            return num;
        } else {
            return recursion(num - 1) + recursion(num - 2);
        }
    }
}
