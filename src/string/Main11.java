package string;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        char check = chars[0];
        result += chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (check == chars[i]) {
                char lastChar = result.charAt(result.length() - 1);
                if (Character.isDigit(lastChar)) {
                    int num = Integer.parseInt(String.valueOf(lastChar));
                    num++;
                    result = result.replaceFirst(".$", Integer.toString(num));
                } else {
                    result += 2;
                }
            } else {
                check = chars[i];
                result += chars[i];
            }
        }
        System.out.println(result);
    }
}
