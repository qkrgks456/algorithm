package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9019 {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            String[] result = new String[10000];
            int[] check = new int[10000];
            Arrays.fill(result, "");
            BFS(a, b, result, check);
        }
        System.out.println(stringBuilder);
    }

    public static void BFS(int a, int b, String[] result, int[] check) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        check[a] = 1;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num == b) {
                stringBuilder.append(result[num] + "\n");
                return;
            }
            if (num >= 0 && num < 10000) {
                // D
                int D;
                if (num * 2 > 9999) {
                    D = num * 2 % 10000;
                } else {
                    D = num * 2;
                }
                if (check[D] == 0) {
                    check[D] = 1;
                    result[D] = result[num] + "D";
                    queue.add(D);
                }
                // S
                int S;
                if (num == 0) {
                    S = 9999;
                } else {
                    S = num - 1;
                }
                if (check[S] == 0) {
                    check[S] = 1;
                    result[S] = result[num] + "S";
                    queue.add(S);
                }

                // L
                int L = (num % 1000 * 10) + (num / 1000);
                if (check[L] == 0) {
                    check[L] = 1;
                    result[L] = result[num] + "L";
                    queue.add(L);
                }
                // R
                int R = (num / 10) + (num % 10 * 1000);
                if (check[R] == 0) {
                    check[R] = 1;
                    result[R] = result[num] + "R";
                    queue.add(R);
                }
            }
        }
    }
}
