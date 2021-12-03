package inflearn.string;

import java.util.Scanner;

public class Main01 {

    public static int good(String str, String str2) {
        String lcstr = str.toLowerCase();
        String lcstr2 = str2.toLowerCase();
        char[] chs = lcstr.toCharArray();
        char ch = lcstr2.charAt(0);
        int result = 0;
        for (char ch2 : chs) {
            if (ch == ch2) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();
        System.out.println(good(input1, input2));
    }
}
