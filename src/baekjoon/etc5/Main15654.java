package baekjoon.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {
    static int N, M;
    static int[] ints, ch, result;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // N개의 자연수 중에서 M개를 고른 수열 중복 x 사전 증가 순
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N];
        result = new int[M];
        ch = new int[10001];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(ints);
        DFS(0);
        System.out.println(stringBuilder);
    }

    public static void DFS(int level) {
        if (level == M) {
            for (int i = 0; i < result.length; i++) {
                stringBuilder.append(result[i] + " ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < ints.length; i++) {
            if (ch[ints[i]] == 0) {
                ch[ints[i]] = 1;
                result[level] = ints[i];
                DFS(level + 1);
                ch[ints[i]] = 0;
            }
        }
    }
}
