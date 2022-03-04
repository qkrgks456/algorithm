package baekjoon.etc;

import java.util.Scanner;

public class Main11726 {
    public static void main(String[] args) {
        int[] ints = new int[1001];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i < ints.length; i++) {
            ints[i] = (ints[i - 1] + ints[i - 2]) % 10007;
        }
        System.out.println(ints[n]);
    }
}
