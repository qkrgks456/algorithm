package baekjoon.v2.bruteforce;

import java.util.Scanner;

public class Main1436 {
    public static void main(String[] args) {
        int i = 1;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (true) {
            i++;
            if (String.valueOf(i).contains("666")) {
                count++;
            }
            if (count == n) {
                System.out.println(i);
                break;
            }
        }
    }
}
