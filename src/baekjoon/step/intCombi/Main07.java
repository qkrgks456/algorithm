package baekjoon.step.intCombi;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = scanner.nextInt();
        System.out.println(factorial(n) / (factorial(n1) * factorial(n - n1)));
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else if (num == 0) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }
    }
}
