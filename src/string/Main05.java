package string;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char trade = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = trade;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
