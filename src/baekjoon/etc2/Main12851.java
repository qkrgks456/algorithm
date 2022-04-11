package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12851 {
    static int N, K;
    static int check = 0;
    static int count = 0;
    static int[] ch, result;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        ch = new int[100001];
        result = new int[100001];
        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }
        BFS();
        System.out.println(check);
    }

    // 아 방법수 구하는거 빡도네 쉬운듯 보이면서 짱구 굴려야되네
    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num == K) {
                check = result[num];
            }
            int n1 = num - 1;
            int n2 = num + 1;
            int n3 = num * 2;
            if (n1 >= 0) {
                if (ch[n1] == 0) {
                    ch[n1] = 1;
                    result[n1] = result[num] + 1;
                    queue.add(n1);
                }
            }
            if (n2 <= 100000) {
                if (ch[n2] == 0) {
                    ch[n2] = 1;
                    result[n2] = result[num] + 1;
                    queue.add(n2);
                }
            }
            if (n3 <= 100001) {
                if (ch[n3] == 0) {
                    ch[n3] = 1;
                    result[n3] = result[num] + 1;
                    queue.add(n3);
                }
            }
        }
    }
}
