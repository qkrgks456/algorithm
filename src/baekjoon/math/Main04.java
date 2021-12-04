package baekjoon.math;

import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[] ints = new int[1000001];
        for (int i = 2; i <= n2; i++) {
            if (ints[i] == 0) {
                if (i >= n1) {
                    System.out.println(i);
                }
                for (int j = i; j <= n2; j = j + i) {
                    if (j % i == 0) {
                        ints[j] = 1;
                    }
                }
            }
        }
    }
}
