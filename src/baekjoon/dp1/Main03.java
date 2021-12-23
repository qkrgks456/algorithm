package baekjoon.dp1;

import java.util.Scanner;

public class Main03 {
    public static int n, count;
    public static int[] ints, ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ints = new int[n + 1];
        ch = new int[n];
        DFS(-1, 0);
        System.out.println(count / 2);
    }

    public static void DFS(int depth, int num) {
        if (depth == n) {
            count++;
            for (int i = 1; i < ints.length; i++) {
                System.out.print(ints[i]);
            }
            System.out.println();
            return;
        } else {
            ints[depth + 1] = num;
            DFS(depth + 1, 1);
            DFS(depth + 1, 0);
        }
    }
}
