package baekjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main08 {

    static int[] ch;
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        ch = new int[100001];
        BFS(n);
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        ch[num] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == k) {
                System.out.println(ch[n] - 1);
                return;
            }
            for (int i = 0; i < 3; i++) {
                int move;
                if (i == 0) {
                    move = n + 1;
                } else if (i == 1) {
                    move = n - 1;
                } else {
                    move = n * 2;
                }
                if (move == k) {
                    System.out.println(ch[n]);
                    return;
                }
                if (move >= 0 && move < 100001 && ch[move] == 0) {
                    queue.add(move);
                    ch[move] = ch[n] + 1;
                }
            }
        }
    }
}
