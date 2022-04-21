package baekjoon.step.math;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                System.out.println(i);
                num /= i;
            }
        }
        if (num != 1) {
            System.out.println(num);
        }
    }
}
