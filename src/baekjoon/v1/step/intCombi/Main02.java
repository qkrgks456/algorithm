package baekjoon.v1.step.intCombi;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        System.out.println(ints[0] * ints[ints.length - 1]);
    }
}
