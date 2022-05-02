package baekjoon.etc5;

import java.util.Scanner;

public class Main17626 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 1;
        int[] ch = new int[50001];
        for (int i = 1; i <= 50000; i++) {
            int chNum = i - (int) Math.sqrt(i);
            while (true) {
                if (chNum == 0) {
                    ch[i] = count;
                } else {

                }
            }
        }
    }
}
