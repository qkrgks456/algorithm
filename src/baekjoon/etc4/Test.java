package baekjoon.etc4;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        int enum1, enum2;
        float result;
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자1 입력:");
        enum1 = sc.nextInt();
        System.out.println("숫자2 입력:");
        enum2 = sc.nextInt();
        result = (float) enum1 / enum2;
        System.out.println(enum1 + "/ " + enum2 + " = " + result);
        System.out.println(result);
        // UPGRADE
        // 1
        System.out.printf("%.2f", result);
        System.out.println();
        // 2
        System.out.println(Math.round(result * 100) / 100.0);
        // 3
        System.out.println(String.format("%.2f", result));
        // 4
        int num = (int) result;
        System.out.println(num + 0.33);
    }
}
