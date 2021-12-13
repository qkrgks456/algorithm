package baekjoon.bruteforce;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 666;
        for (int i = 2; i <= n; i++) {
            String s = String.valueOf(result);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '6') {
                    count++;
                }
            }
            if (count > 3) {

            } else {
                result += 1000;
            }
        }
        System.out.println(result);
    }
}
