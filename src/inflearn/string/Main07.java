package inflearn.string;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String str = input.toLowerCase();
        char[] chars = str.toCharArray();
        boolean check = false;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                System.out.println("NO");
                break;
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("YES");
        }
    }
}
