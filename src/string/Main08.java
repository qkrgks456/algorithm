package string;

import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String match = "[^\uAC00-\uD7A3a-zA-Z]";
        str = str.replaceAll(match, "");
        str = str.toLowerCase();
        String str2 = new StringBuilder(str).reverse().toString();
        if (str.equals(str2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
