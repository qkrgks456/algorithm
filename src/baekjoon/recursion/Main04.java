package baekjoon.recursion;

import java.util.Scanner;

public class Main04 {
    // 하노이탑 너무 어렵다
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        stringBuilder.append(((int) Math.pow(2, n) - 1) + "\n");
        recursion(n, 1, 2, 3);
        System.out.println(stringBuilder);
    }

    // n=k
    // n=k-1
    public static void recursion(int n, int start, int assist, int result) {
        if (n == 1) {
            stringBuilder.append(start + " " + result + "\n");
            return;
        } else {
            // A -> B N-1개
            recursion(n - 1, start, result, assist);
            // A -> C 실제 이동 1개
            stringBuilder.append(start + " " + result + "\n");
            // B -> C N-1개
            recursion(n - 1, assist, start, result);
        }
    }
}
