package inflearn.string;

import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = scanner.next();
        String result = "";
        str = str.replaceAll("#", "1").replaceAll("\\*", "0");
        for (int i = 0; i < num; i++) {
            int first = i * 7;
            int last = (i + 1) * 7;
            String s = str.substring(first, last);
            int tenNum = Integer.parseInt(s, 2);
            char text = (char) tenNum;
            result += text;
        }
        System.out.println(result);
    }
}
