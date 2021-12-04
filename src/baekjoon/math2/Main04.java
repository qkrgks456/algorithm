package baekjoon.math2;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x == 0 && y == 0 && z == 0) break;
            int max = Math.max(z, Math.max(x, y));
            if (max == x) {
                if (x * x == y * y + z * z) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (max == y) {
                if (y * y == x * x + z * z) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else {
                if (z * z == y * y + x * x) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }
}
