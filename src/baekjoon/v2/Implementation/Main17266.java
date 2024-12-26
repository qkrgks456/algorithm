package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17266 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[M];
        for (int i = 0; i < M; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        // 시작점에서 첫번째 조명까지의 거리
        int start = ints[0];
        // 조명들 2개사이의 거리의 최대값
        int result = 0;
        for (int i = 1; i < M; i++) {
            int distance = Math.abs(ints[i] - ints[i - 1]);
            result = Math.max(result, (distance + 1) / 2);
        }
        // 마지막점에서 마지막 길까지의 거리
        int end = N - ints[M - 1];

        System.out.println(Math.max(result, Math.max(start, end)));

    }
}
