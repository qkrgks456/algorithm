package baekjoon.math2;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x = 0;
        int y = 0;
        if (y1 != y2 && x1 != x2) {
            x = (x1 + x2) - x3;
            y = (y1 + y2) - y3;
        } else if (y1 != y3 && x1 != x3) {
            x = (x1 + x3) - x2;
            y = (y1 + y3) - y2;
        } else if (y2 != y3 && x2 != x3) {
            x = (x2 + x3) - x1;
            y = (y2 + y3) - y1;
        }
        System.out.println(x + " " + y);
    }
}
