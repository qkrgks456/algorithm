package inflearn.string;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] results = new String[count];
        for (int i = 0; i < count; i++) {
            String str = scanner.next();
            char[] chars = str.toCharArray();
            String result = "";
            for (int j = chars.length - 1; 0 <= j; j--) {
                result += chars[j];
            }
            results[i] = result;
        }
        for (String res : results) {
            System.out.println(res);
        }
    }
}
