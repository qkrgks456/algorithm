package baekjoon.v1.etc5;

import java.util.Scanner;

public class Main17626 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ch = new int[num + 1];
        ch[1] = 1;
        for (int i = 2; i <= num; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, ch[i - j * j]);
            }
            ch[i] = min + 1;
        }
        System.out.println(ch[num]);
    }
}
