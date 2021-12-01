package dfsbfs;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(test(num));
    }

    public static int test(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * test(num - 1);
        }
    }
}
