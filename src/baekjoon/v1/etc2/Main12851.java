package baekjoon.v1.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12851 {
    static int N, K;
    static int check = Integer.MAX_VALUE;
    static int count = 0;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        result = new int[100001];
        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }
        BFS();
        System.out.println(check);
        System.out.println(count);
    }

    // 아 방법수 구하는거 빡도네 쉬운듯 보이면서 짱구 굴려야되네
    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (result[num] > check) return;
            if (num == K && result[num] <= check) {
                check = result[num];
                count++;
            }

            int n1 = num - 1;
            int n2 = num + 1;
            int n3 = num * 2;
            if (n1 >= 0) {
                if (result[n1] == 0 || result[n1] >= result[num] + 1) {
                    result[n1] = result[num] + 1;
                    queue.add(n1);
                }
            }
            if (n2 <= 100000) {
                if (result[n2] == 0 || result[n2] >= result[num] + 1) {
                    result[n2] = result[num] + 1;
                    queue.add(n2);
                }
            }
            if (n3 <= 100001) {
                if (result[n3] == 0 || result[n3] >= result[num] + 1) {
                    result[n3] = result[num] + 1;
                    queue.add(n3);
                }
            }

        }
    }
}
