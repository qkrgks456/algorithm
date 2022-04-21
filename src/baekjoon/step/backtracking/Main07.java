package baekjoon.step.backtracking;

import java.util.Scanner;

public class Main07 {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] ints, cals;
    static int n;

    // 연산식 한번 끝까지 해보자
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
        recursion(1, ints[0]);
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
                if (cals[i] != 0) {
                    cals[i]--;
                    switch (i) {
                        case 0:
                            recursion(num + 1, sum + ints[num]);
                            break;
                        case 1:
                            recursion(num + 1, sum - ints[num]);
                            break;
                        case 2:
                            recursion(num + 1, sum * ints[num]);
                            break;
                        case 3:
                            recursion(num + 1, sum / ints[num]);
                            break;
                    }
                    cals[i]++;
                }
            }
        }
    }
}
