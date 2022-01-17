package baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ints = new int[n];
        int[] ints1 = new int[m];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        for (int i = 0; i < m; i++) {
            ints1[i] = scanner.nextInt();
        }
        for (int i = 0; i < ints1.length; i++) {
            int l = 0;
            int r = n - 1;
            while (true) {
                int mid = r / 2 + 1;
                if (ints[mid] == ints1[i]) {
                    System.out.println(1);
                    break;
                } else if (ints[mid] < ints1[i]) {
                    mid = l;
                } else if (ints[mid] > ints1[i]) {

                }
            }
        }
    }
}
