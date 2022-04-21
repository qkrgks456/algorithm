package baekjoon.step.intCombi;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int num = numReturn(ints[0], ints[i]);
            System.out.println(ints[0] / num + "/" + ints[i] / num);
        }
    }

    // 두수의 최대 공약수 가져오는거
    public static int numReturn(int n1, int n2) {
        int num = 0;
        if (n2 > n1) {
            while (true) {
                num = n2 % n1;
                if (num == 0) {
                    return n1;
                }
                n2 = n1;
                n1 = num;
            }
        } else {
            while (true) {
                num = n1 % n2;
                if (num == 0) {
                    return n2;
                }
                n1 = n2;
                n2 = num;
            }
        }
    }
}
