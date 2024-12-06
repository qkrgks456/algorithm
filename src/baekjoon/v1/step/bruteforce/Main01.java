package baekjoon.v1.step.bruteforce;

import java.util.Scanner;

public class Main01 {
    static int n, n1 = 0;
    static int[] ints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        n1 = scanner.nextInt();
        ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println(DFS(0, 0, 0));
    }

    public static int DFS(int num, int sum, int count) {
        if (sum > n1) {
            return 0;
        } else if (count == 3) {
            return sum;
        } else if (num == n) {
            return 0;
        } else {
            int a1 = DFS(num + 1, sum + ints[num], count + 1);
            int a2 = DFS(num + 1, sum, count);
            return Math.max(a1, a2);
        }
    }
}
