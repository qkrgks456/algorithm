package baekjoon.bruteforce;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = i;
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if (i + sum == n) {
                check = false;
                System.out.println(i);
                break;
            }
        }
        if (check) {
            System.out.println(0);
        }
    }
}
