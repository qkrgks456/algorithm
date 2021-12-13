package baekjoon.bruteforce;

import java.util.Scanner;

public class Main04 {
    static char[][] chars;
    static int min = Integer.MAX_VALUE;
    static char[][] wChars =
            {
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            };
    static char[][] bChars =
            {
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        chars = new char[x][y];
        for (int i = 0; i < x; i++) {
            String s = scanner.next();
            for (int j = 0; j < y; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        for (int j = 0; j < x - 7; j++) {
            for (int k = 0; k < y - 7; k++) {
                min(j, k);
            }
        }
        System.out.println(min);
    }

    public static void min(int x, int y) {
        int wCount = 0;
        int bCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chars[x + i][y + j] != wChars[i][j]) {
                    wCount++;
                } else if (chars[x + i][y + j] != bChars[i][j]) {
                    bCount++;
                }
            }
        }
        int good = Math.min(wCount, bCount);
        min = Math.min(min, good);
    }
}
