package studymylove;

import java.util.Scanner;

public class Test16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String s = scanner.next();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                break;
            }
            System.out.println(s);
        }

        do {
            String s = scanner.next();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                break;
            }
            System.out.println(s);
        } while (true);

        while (true) {
            String s = scanner.next();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                break;
            }
            System.out.println(s);
        }
    }
}
