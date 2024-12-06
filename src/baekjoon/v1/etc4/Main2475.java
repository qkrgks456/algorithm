package baekjoon.v1.etc4;

import java.util.Scanner;

public class Main2475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            result += Math.pow(n, 2);
        }
        System.out.println(result % 10);
    }
}
