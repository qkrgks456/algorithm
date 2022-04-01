package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5014 {
    static int f, s, g, u, d;
    static int[] check;
    static int[] level;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        f = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());
        g = Integer.parseInt(stringTokenizer.nextToken());
        u = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());
        check = new int[f + 1];
        level = new int[f + 1];
        BFS(s);
    }

    public static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = 1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == g) {
                System.out.println(level[num]);
                return;
            }
            if (num - d >= 0) {
                if (check[num - d] == 0) {
                    check[num - d] = 1;
                    level[num - d] = level[num] + 1;
                    queue.add(num - d);
                }
            }
            if (num + u < f) {
                if (check[num + u] == 0) {
                    check[num + u] = 1;
                    level[num + u] = level[num] + 1;
                    queue.add(num + u);
                }
            }
        }
        System.out.println("use the stairs");
    }
}
