package baekjoon.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[N][M];
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                min = Math.min(ints[i][j], min);
                max = Math.max(ints[i][j], max);
            }
        }
        // 어차피 최대치 넘거나, 최소치 아래면 최소시간이 나올수 없음
        for (int i = min; i <= max; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {

                }
            }
        }

    }
}
