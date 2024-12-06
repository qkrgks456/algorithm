package baekjoon.v1.step.intCombi;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[501];
        int[] ints1 = new int[501];
        int count = 0;
        for (int i = 5; i <= 500; i++) {
            if (i % 5 == 0) {
                count++;
                int n1 = i / 5;
                while (true) {
                    if (n1 % 5 == 0) {
                        count++;
                        n1 = n1 / 5;
                    } else {
                        break;
                    }
                }
            }
            ints[i] = count;
        }
        count = 0;
        for (int i = 2; i <= 500; i++) {
            if (i % 2 == 0) {
                count++;
                int n1 = i / 2;
                while (true) {
                    if (n1 % 2 == 0) {
                        count++;
                        n1 = n1 / 2;
                    } else {
                        break;
                    }
                }
            }
            ints1[i] = count;
        }
        System.out.println(ints[n]);
        System.out.println(ints1[n]);
    }
}
