package baekjoon.step.backtracking;

import java.util.Scanner;

//10974번 모든 순열
public class Main09 {
    static int[] result;
    static int[] check;
    static int n;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        check = new int[n + 1];
        result = new int[n];
        DFS(0);
        System.out.println(stringBuilder);
    }

    public static void DFS(int num) {
        if (n == num) {
            for (int i = 0; i < n; i++) {
                stringBuilder.append(result[i] + " ");
            }
            stringBuilder.append("\n");
        }
        for (int i = 1; i < n + 1; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                result[num] = i;
                DFS(num + 1);
                check[i] = 0;
            }
        }
    }
}
