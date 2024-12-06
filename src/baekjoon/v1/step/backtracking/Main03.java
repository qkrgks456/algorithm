package baekjoon.v1.step.backtracking;

import java.util.Scanner;

public class Main03 {
    static int n, m;
    static int[] result;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        result = new int[m];
        DFS(0);
        System.out.println(stringBuilder);

    }

    public static void DFS(int num) {
        if (num == m) {
            for (int n : result) {
                stringBuilder.append(n + " ");
            }
            stringBuilder.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                result[num] = i;
                DFS(num + 1);
            }
        }
    }
}
