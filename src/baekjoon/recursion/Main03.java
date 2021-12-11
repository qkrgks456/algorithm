package baekjoon.recursion;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main03 {
    static char[][] chars;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        chars = new char[n][n];
        recursion(0, 0, n, false);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(chars[i]);
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void recursion(int x, int y, int n, boolean check) {
        if (check) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    chars[i][j] = ' ';
                }
            }
            return;
        }
        if (n == 1) {
            chars[x][y] = '*';
            return;
        }

        int size = n / 3;
        int count = 0;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;
                if (count == 5) {
                    recursion(i, j, size, true);
                } else {
                    recursion(i, j, size, false);
                }
            }
        }
    }
}
