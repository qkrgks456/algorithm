package string;

import java.util.ArrayList;
import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (char ch : chars) {
            if (list.size() == 0) {
                list.add(ch);
            } else {
                if (!list.contains(ch)) {
                    list.add(ch);
                }
            }
        }
        String str2 = "";
        for (Character ch : list) {
            str2 += ch.toString();
        }
        System.out.println(str2);
    }
}
