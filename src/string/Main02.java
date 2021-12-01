package string;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        String result = "";
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                result += Character.toUpperCase(ch);
            } else {
                result += Character.toLowerCase(ch);
            }
        }
        System.out.println(result);
    }
}
