package baekjoon.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16928 {
    static int[] ints, ch, result;

    public static void main(String[] args) throws Exception {
        // 뱀이 함정인가 ??
        // 뱀을 굳이 갈 필요가 없는것 같은데
        ints = new int[101];
        ch = new int[101];
        result = new int[101];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N + M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            ints[n1] = n2;
        }
        BFS();
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        ch[1] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            // 100에 도착했다면
            if (n == 100) {
                System.out.println(result[100]);
                break;
            }
            // 주사위 굴리기
            for (int i = 1; i <= 6; i++) {
                int dx = n + i;
                // 기본조건
                if (dx < 101 && ch[dx] == 0) {
                    ch[dx] = 1;
                    // 뱀이나 사다리인지
                    if (ints[dx] > 0) {
                        if (ch[ints[dx]] == 0) {
                            ch[ints[dx]] = 1;
                            result[ints[dx]] = result[n] + 1;
                            queue.add(ints[dx]);
                        }
                    } else {
                        result[dx] = result[n] + 1;
                        queue.add(dx);
                    }
                }
            }
        }
    }
}
