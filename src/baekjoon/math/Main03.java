package baekjoon.math;

import java.util.Scanner;

public class Main03 {
    static int[] ints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = 0;
        ints = new int[1001];
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            if (n > 1) {
                if (numCheck(n)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean numCheck(int val) {
        boolean check = true;
        if (ints[val] == 0) {
            for (int i = 2; i < val; i++) {
                if (val % i == 0) {
                    check = false;
                    ints[val] = 1;
                }
            }
        } else {
            check = false;
        }
        return check;
    }
}
