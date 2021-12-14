package baekjoon.sort;

import java.util.Scanner;

public class Main01 {
    // 삽입 정렬
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int num = 0;
        while (num < ints.length - 1) {
            if (ints[num] > ints[num + 1]) {
                int nums = ints[num];
                ints[num] = ints[num + 1];
                ints[num + 1] = nums;
                if (num != 0) {
                    num--;
                } else {
                    num++;
                }
            } else {
                num++;
            }
        }
        for (int s : ints) {
            System.out.println(s);
        }
    }
}
