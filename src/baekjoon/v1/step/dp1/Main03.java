package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main03 {
    public static int n, count;
    public static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ch = new int[n + 1];
        System.out.println(DFS(n));

    }

    public static int DFS(int num) {
        if (ch[num] != 0) {
            return ch[num];
        }
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else {
            return ch[num] = (DFS(num - 1) + DFS(num - 2)) % 15746;
        }
    }
}
