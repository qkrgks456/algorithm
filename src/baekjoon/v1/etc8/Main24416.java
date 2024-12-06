package baekjoon.v1.etc8;

import java.util.Scanner;

public class Main24416 {
    static int count2 = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 1;
        int count = 0;
        for (int i = 2; i < ints.length; i++) {
            count++;
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        DFS(n);
        System.out.println(count2 + " " + count);
    }

    public static int DFS(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        count2++;
        return DFS(num - 1) + DFS(num - 2);
    }
}
