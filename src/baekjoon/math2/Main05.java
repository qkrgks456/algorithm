package baekjoon.math2;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        double n = Math.PI * r * r;
        double n1 = 2 * (r * r);
        System.out.println(String.format("%.6f", n));
        System.out.println(String.format("%.6f", n1));
    }
}
