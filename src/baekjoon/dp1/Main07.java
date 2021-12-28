package baekjoon.dp1;

import java.util.Scanner;

public class Main07 {
    static int[] ints;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = scanner.nextInt();
        }
        ch[0] = ints[0];
        ch[1] = ints[1];
        if (n >= 2) {
            ch[2] = ints[1] + ints[2];
        }
        System.out.println(DFS(n));
    }


    public static int DFS(int num) {
        if (ch[num] != 0) {
            return ch[num];
        }
        if (num == 0) {
            return 0;
        }
        return ch[num] = Math.max(DFS(num - 2), DFS(num - 3) + ints[num - 1]) + ints[num];
    }
}
