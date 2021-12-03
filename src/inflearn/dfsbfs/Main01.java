package inflearn.dfsbfs;

import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        test(num);
    }

    public static void test(int num) {
        if (num != 0) {
            test(num - 1);
            System.out.print(num + " ");
        }
    }
}
