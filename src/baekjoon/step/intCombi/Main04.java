package baekjoon.step.intCombi;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int oneNum = n1;
            int twoNum = n2;
            int num = 0;
            int result = 0;
            if (n1 > n2) {
                while (true) {
                    num = n1 % n2;
                    if (num == 0) {
                        result = n2;
                        break;
                    }
                    n1 = n2;
                    n2 = num;
                }
            } else {
                while (true) {
                    num = n2 % n1;
                    if (num == 0) {
                        result = n1;
                        break;
                    }
                    n2 = n1;
                    n1 = num;
                }
            }
            System.out.println((oneNum / result) * (twoNum / result) * result);
        }
    }
}
