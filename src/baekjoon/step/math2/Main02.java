package baekjoon.step.math2;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int xm = Math.min(x, w - x);
        int ym = Math.min(y, h - y);
        System.out.println(Math.min(xm, ym));
    }
}
