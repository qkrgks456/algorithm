package array;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int num1 = 1;
        int num2 = 1;
        int num3 = 1;
        for (int i = 0; i < input; i++) {
            num1 = num3;
            // 1 + 3
            if (i < 2) {
                System.out.print(num1 + " ");
            } else {
                // 2 + 3
                System.out.print(num1 + num2 + " "); // 1 + 2
                num3 = num2;
                num2 = num1 + num2; // 3
                // 5
            }
        }
    }
}
