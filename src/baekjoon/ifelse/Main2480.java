package baekjoon.ifelse;

import java.util.Scanner;

public class Main2480 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        if (n == n1 && n1 == n2) {
            System.out.println(10000 + n * 1000);
        } else if (n == n1 || n1 == n2 || n == n2) {
            if (n == n1 || n == n2) {
                System.out.println(1000 + n * 100);
            } else {
                System.out.println(1000 + n1 * 100);
            }
        } else {
            if (n > n1 && n > n2) {
                System.out.println(n * 100);
            } else if (n1 > n && n1 > n2) {
                System.out.println(n1 * 100);
            } else if (n2 > n && n2 > n1) {
                System.out.println(n2 * 100);
            }
        }
    }
}
