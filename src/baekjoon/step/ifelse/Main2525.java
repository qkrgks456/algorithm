package baekjoon.step.ifelse;

import java.util.Scanner;

public class Main2525 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (b + c < 60) {
            System.out.println(a + " " + (b + c));
        } else {
            int num = b + c;
            int h = num / 60;
            int m = num % 60;
            if (a + h < 24) {
                System.out.println((a + h) + " " + m);
            } else {
                num = a + h;
                int result = num - 24;
                System.out.println(result + " " + m);
            }
        }
    }
}
