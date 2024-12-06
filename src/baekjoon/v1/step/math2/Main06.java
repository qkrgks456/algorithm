package baekjoon.v1.step.math2;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            int d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (Math.sqrt(d) > r1 + r2 || d < Math.pow(r2 - r1, 2)) {
                System.out.println(0);
            } else if (d == Math.pow(r2 - r1, 2)) {
                System.out.println(1);
            } else if (d == Math.pow(r2 + r1, 2)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
