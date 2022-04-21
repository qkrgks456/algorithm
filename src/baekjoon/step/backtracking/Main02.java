package baekjoon.step.backtracking;

import java.util.Scanner;

public class Main02 {
    static int n, m;
    static int result[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        result = new int[m];
        DFS(1, 0);
    }

    public static void DFS(int num, int depth) {
        if (depth == m) {
            for (int n : result) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = num; i <= n; i++) {
                result[depth] = i;
                DFS(i + 1, depth + 1);
            }
        }
    }
}
