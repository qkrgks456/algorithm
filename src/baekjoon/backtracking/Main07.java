package baekjoon.backtracking;

import java.util.Scanner;

public class Main07 {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] ints, cals;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ints = new int[n];
        cals = new int[4];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            cals[i] = scanner.nextInt();
        }
        recursion(0, ints[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void recursion(int num, int sum) {
        if (num == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < cals[i]; j++) {
                    if (i == 0) {
                        recursion(num + 1, sum += ints[num]);
                    } else if (i == 1) {
                        recursion(num + 1, sum -= ints[num]);
                    } else if (i == 2) {
                        recursion(num + 1, sum *= ints[num]);
                    } else if (i == 3) {
                        sum = Math.abs(sum);
                        recursion(num + 1, sum /= ints[num]);
                    }
                }
            }
        }
    }
}
