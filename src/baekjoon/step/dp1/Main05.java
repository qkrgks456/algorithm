package baekjoon.step.dp1;

import java.util.Scanner;

public class Main05 {
    static int[][] ints;
    static int[][] ch;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ints = new int[n][3];
        ch = new int[n][3];
        for (int i = 0; i < n; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
            ints[i][2] = scanner.nextInt();
        }
        // 체크할 배열
        ch[0][0] = ints[0][0];
        ch[0][1] = ints[0][1];
        ch[0][2] = ints[0][2];
        // 시작점이 레드일때
        // 시작점이 블루일때
        // 시작점이 그린일때
        System.out.println(Math.min(DFS(n - 1, 0), Math.min(DFS(n - 1, 1), DFS(n - 1, 2))));
    }

    public static int DFS(int num, int color) {
        if (ch[num][color] != 0) {
            return ch[num][color];
        }
        if (color == 0) {
            return ch[num][color] = Math.min(DFS(num - 1, 1), DFS(num - 1, 2)) + ints[num][0];
        } else if (color == 1) {
            return ch[num][color] = Math.min(DFS(num - 1, 0), DFS(num - 1, 2)) + ints[num][1];
        } else {
            return ch[num][color] = Math.min(DFS(num - 1, 0), DFS(num - 1, 1)) + ints[num][2];
        }
    }
}
