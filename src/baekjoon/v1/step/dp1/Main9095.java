package baekjoon.v1.step.dp1;

import java.util.Scanner;

public class Main9095 {
    public static void main(String[] args) {
        int[] ints = new int[11];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 4;
        for (int i = 4; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2] + ints[i - 3];
        }
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            System.out.println(ints[num]);
        }
    }
}
