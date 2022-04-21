package baekjoon.step.math;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int distance = 0;
        int max = 0;
        for (int i = 0; i < num; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            distance = n2 - n1;
            max = (int) Math.sqrt(distance);
            if (max == Math.sqrt(distance)) {
                System.out.println(2 * max - 1);
            } else if (distance <= max * max + max) {
                System.out.println(2 * max);
            } else {
                System.out.println(2 * max + 1);
            }
        }
    }
}
