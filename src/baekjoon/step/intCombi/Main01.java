package baekjoon.step.intCombi;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int n1 = scanner.nextInt();
            if (n == 0 && n1 == 0) {
                break;
            }
            if (n1 % n == 0) {
                System.out.println("factor");
            } else if (n % n1 == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}
