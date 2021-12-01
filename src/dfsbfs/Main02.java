package dfsbfs;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        test(num);
    }

    public static void test(int num) {
        if (num == 1) {
            System.out.print(1);
        } else {
            test(num / 2);
            System.out.print(num % 2);
        }

    }
}
