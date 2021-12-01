package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main08 {
    public static int n2;
    public static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int n1 = Integer.parseInt(strings[0]);
        n2 = Integer.parseInt(strings[1]);
        BFS(n1);
    }

    public static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        ch = new int[10001];
        queue.add(n);
        ch[n] = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                if (cur > 0) {
                    if (ch[cur + 1] == 0) {
                        queue.add(cur + 1);
                        ch[cur + 1] = 1;
                    }
                    if (ch[cur - 1] == 0) {
                        queue.add(cur - 1);
                        ch[cur - 1] = 1;
                    }
                    if (ch[cur + 5] == 0) {
                        queue.add(cur + 5);
                        ch[cur + 5] = 1;
                    }
                }
                if (cur == n2) {
                    queue.clear();
                    break;
                }
            }
            level++;
        }
        System.out.println(level - 1);
    }
}
