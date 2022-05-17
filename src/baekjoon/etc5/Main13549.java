package baekjoon.etc5;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13549 {
    static int N, K, min;
    static int[] ch;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        ch = new int[100001];
        result = new int[100001];
        if (N == K) {
            System.out.println(0);
            System.exit(0);
        }
        BFS();
        System.out.println(min);
    }

    public static void BFS() {
        // 언제까지 돌아야 할까 그러면 조건은? 그냥 다 돌아
        min = Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            ch[point.x] = 1;
            if (point.x == K) {
                min = Math.min(point.y, min);
            }
            int n1 = point.x * 2;
            int n2 = point.x + 1;
            int n3 = point.x - 1;
            if (n1 < 100001 && ch[n1] == 0) {
                queue.add(new Point(n1, point.y));
            }
            if (n2 < 100001 && ch[n2] == 0) {
                queue.add(new Point(n2, point.y + 1));
            }
            if (n3 >= 0 && ch[n3] == 0) {
                queue.add(new Point(n3, point.y + 1));
            }
        }
    }
}
