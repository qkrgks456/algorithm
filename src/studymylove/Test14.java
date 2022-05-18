package studymylove;

import java.util.Scanner;

public class Test14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(max(a, b, c));

    }

    private static int max(int a, int b, int c) {
        int result = 0;
        if (a > b && a > c) {
            result = a;
        } else if (b > a && b > c) {
            result = b;
        } else {
            result = c;
        }
        return result;
    }

}