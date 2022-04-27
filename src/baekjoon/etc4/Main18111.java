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
        int result = Integer.MAX_VALUE;
        int height = 0;
        for (int i = min; i <= max; i++) {
            int time = 0;
            int check = B;
            // 이게 한 플로우
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (ints[j][k] > i) {
                        // 크다면 2초로
                        time += (ints[j][k] - i) * 2;
                        check += ints[j][k] - i;
                    } else if (ints[j][k] < i) {
                        time += i - ints[j][k];
                        check -= i - ints[j][k];
                    }
                }
            }
            if (check >= 0) {
                if (result >= time) {
                    result = time;
                    height = i;
                }
            }
        }
        System.out.println(result + " " + height);
    }
}
