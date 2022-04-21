package baekjoon.step.backtracking;

import java.util.Scanner;

public class Main04 {
    static int n, m;
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        result = new int[m];
        DFS(1, 0);
        System.out.println(stringBuilder);
    }

    public static void DFS(int num, int depth) {
        if (depth == m) {
            for (int n : result) {
                stringBuilder.append(n + " ");
            }
            stringBuilder.append("\n");
        } else {
            for (int i = num; i <= n; i++) {
                result[depth] = i;
                DFS(i, depth + 1);
            }
        }
    }
}
