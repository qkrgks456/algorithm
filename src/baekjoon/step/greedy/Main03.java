package baekjoon.step.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Main03 {
    // 대놓고 정렬하라고 알려주누 ㅋㅋㅋ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        ch[0] = ints[0];
        int sum = ints[0];
        for (int i = 1; i < ints.length; i++) {
            ch[i] = ch[i - 1] + ints[i];
            sum += ch[i];
        }
        System.out.println(sum);
    }
}
