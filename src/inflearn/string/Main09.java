package inflearn.string;

import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String match = "[^0-9]";
        str = str.replaceAll(match, "");
        System.out.println(Integer.parseInt(str));
    }
}
